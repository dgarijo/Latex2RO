/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * Copyright 2012-2013 Ontology Engineering Group, Universidad Politécnica de Madrid, Spain
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package latextorocreator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class designed to create an RO from a latex file
 * @author Daniel Garijo
 */
public class ROCreator {

    public ROCreator(){
        
    }
  
    /**
     * Given a save path, an optiopnal latex file an a set of creators, 
     * this method creates the html representation of the RO annotated in RDF-a.     
     * @param savePath
     * @param latexFilePath
     * @param creators
     * @throws Exception 
     */
    public void createRO(String savePath, String latexFilePath, ArrayList<String> creators) throws Exception {
        if(savePath.equals(""))throw new Exception("Wrong save file path");            
            try{
                File dir = new File(savePath);
                if(!dir.exists())dir.mkdir();
                String title = "Title goes here";
                String abstractSection = "Here you should see your abstract section";
                if(!"".equals(latexFilePath)){
                    LatexParser p = new LatexParser("sigproc-sp.tex");
                    title = p.getTitle();
                    abstractSection = p.getAbstractSection();                            
                }                
                String textToHTML = "";
                textToHTML+=ConstantsForHTML.headFirst+"<title>"+title+"</title>\n"+ConstantsForHTML.headEnd;
                textToHTML+=ConstantsForHTML.bodyFirst+title+ConstantsForHTML.bodySecondAndAbstract;
                textToHTML+=abstractSection;
                textToHTML+=ConstantsForHTML.bodyThirdAndInputsAndResults;
                textToHTML+=ConstantsForHTML.bodyFourthAndAboutAuthors;
                if(creators.isEmpty()){
                    textToHTML+="<tr><td style=\"padding-left:10px\">First author name</td><td style=\"padding-left:10px\">Author description or institution</td></tr>";
                }else{
                    Iterator it = creators.iterator();
                    while(it.hasNext()){
                        textToHTML+="<tr property=\"schema:creator dc:creator\" "
                                + "typeOf=\"foaf:Person\"><td style=\"padding-left:10px\" "
                                + "property=\"foaf:name schema:name\">"+it.next()+"</td><td "
                                + "style=\"padding-left:10px\">Author description or institution"
                                + "</td></tr>";
                    }
                }
                textToHTML+=ConstantsForHTML.bodyFifthAndEnd;
                /**
                 * Save file to the desired folder (along with the rest of the resources)
                 */
                System.out.println("Generating HTML file "+savePath+File.separator+"ro.html...");
                FileWriter fstreamTemplate = new FileWriter(savePath+File.separator+"ro.html");
                BufferedWriter outTemplate = new BufferedWriter(fstreamTemplate);
                outTemplate.write(textToHTML);
                outTemplate.close();
                fstreamTemplate.close();
                System.out.println("Done!!");
            }catch(Exception e){
                System.err.println("Error while saving the Research Object: "+e.getMessage());
            }
    }
//    queda: hacer la copia de ficheros a carpeta destino; si no existe crearla
//           con la GUI: completar GUI
    public static void main(String[]args){
        //parse arguments -l (latex), -s (save as) and -c (creator)
        int i=0;
        String currentArg="";
        ArrayList<String> creators =null;
        String pathLatexFile="";
        String pathFolderRO="";
        try{
            while (i<args.length){
                currentArg = args[i];
                if(currentArg.equals("-l")){
                    pathLatexFile = args[i+1];
                }else if(currentArg.equals("-s")){
                    pathFolderRO = args[i+1];
                }else if(currentArg.equals("-c")){
                    if(creators==null)creators=new ArrayList<String>();
                    creators.add(args[i+1].replace("_", " "));                    
                   }
                i++;
            }
            new ROCreator().createRO(pathFolderRO, pathLatexFile, creators);
    
        }catch(Exception e){
            System.err.println(e.getMessage()+"\nWrong usage of commands. Example: java -jar ROCreator.java -s ResearchObjectSavePath [-l latexFilePath} [-c CreatorName_CreatorSurname]");
        }
    }
}

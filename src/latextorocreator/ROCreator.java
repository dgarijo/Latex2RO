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
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
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
                if(latexFilePath!=null && !"".equals(latexFilePath)){
                    LatexParser p = new LatexParser(latexFilePath);
                    title = p.getTitle();
                    abstractSection = p.getAbstractSection();                            
                }                
                String textToHTML = "";
                textToHTML+=ConstantsForHTML.headFirst+"<title>"+title+"</title>\n"+ConstantsForHTML.headEnd;
                textToHTML+=ConstantsForHTML.bodyFirst+title+ConstantsForHTML.bodySecondAndAbstract;
                textToHTML+=abstractSection;
                textToHTML+=ConstantsForHTML.bodyThirdAndInputsAndResults;
                textToHTML+=ConstantsForHTML.bodyFourthAndAboutAuthors;
                if(creators == null || creators.isEmpty()){
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
                System.out.println("Generating HTML file "+savePath+File.separator +"myResearchObject"+new Date().getTime()+".html...");
                FileWriter fstreamTemplate = new FileWriter(savePath+File.separator+"myResearchObject"+new Date().getTime()+".html");
                BufferedWriter outTemplate = new BufferedWriter(fstreamTemplate);
                outTemplate.write(textToHTML);
                outTemplate.close();
                fstreamTemplate.close();
                System.out.println("Done. Copying the rest of the html resources...");
                
                //Copy of the rest of the resources of the html web page.
                //As I haven't found any other way to embed the reosurces in the
                //dist file and copy them afterwards to the folder selected by the
                //user, this is the way it is done right now.
                
//                File f = new File ("resources/flex-slider/flexslider.css");
                String [] flexSlider = ConstantsForHTML.resourcesFlexSlider;
                String [] flexSliderTheme = ConstantsForHTML.resourcesFlexSliderTheme;
                String [] images = ConstantsForHTML.resourcesImages;
                String [] scripts = ConstantsForHTML.resourcesScripts;
                String [] styles = ConstantsForHTML.resourcesStyles;
                String [] stylesFonts = ConstantsForHTML.resourcesStylesFonts;
                
                File flexSliderFolder = new File(savePath+File.separator+ "flex-slider");
                flexSliderFolder.mkdir();
                File flexSliderThemeFolder = new File(flexSliderFolder.getAbsolutePath()+File.separator+ "theme");
                flexSliderThemeFolder.mkdir();
                File imagesFolder = new File(savePath+File.separator+ "images");
                imagesFolder.mkdir();
                File scriptsFolder = new File(savePath+File.separator+ "scripts");
                scriptsFolder.mkdir();
                File stylesFolder = new File(savePath+File.separator+ "styles");
                stylesFolder.mkdir();
                File fontsFolder = new File(stylesFolder.getAbsolutePath()+File.separator+ "Fonts");
                fontsFolder.mkdir();
                
                copyResourceFolder(flexSlider, flexSliderFolder.getAbsolutePath());
                copyResourceFolder(flexSliderTheme, flexSliderThemeFolder.getAbsolutePath());
                copyResourceFolder(images, imagesFolder.getAbsolutePath());
                copyResourceFolder(scripts, scriptsFolder.getAbsolutePath());
                copyResourceFolder(styles, stylesFolder.getAbsolutePath());
                copyResourceFolder(stylesFonts, fontsFolder.getAbsolutePath());               
                System.out.println("Done.");
                
            }catch(Exception e){
                System.err.println("Error while saving the Research Object: "+e.getMessage());
            }
    }
    
    private void copyResourceFolder(String[] resources, String savePath) throws IOException{
        for(int i=0; i<resources.length;i++){
            String aux = resources[i].substring(resources[i].lastIndexOf("/")+1,resources[i].length());
            File b = new File(savePath+File.separator+aux);
            b.createNewFile();                
            copyROFile(resources[i], b);
        }
    }
    
    /**
     * Method used to copy all the RO related files: styles, images, etc.
     * @param source
     * @param dest
     * @throws IOException 
     */
    private void copyROFile(String resourceName, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = ROCreator.class.getResourceAsStream(resourceName);//new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
        finally {
            is.close();
            os.close();
        }
    }
//    queda: copiar ficheros con el metodo (^).
//           con la GUI: completar GUI
//           comprobar que el html producido sea correcto.
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

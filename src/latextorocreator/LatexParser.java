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

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Class designed to obtain Title, and abstract of a latex file.
 * If these attributes are not defined, they will be left blank.
 * Authors were not included as there are many different ways to declare them.
 * If additional details are to be extracted from the files, this is the class
 * to expand.
 * @author Daniel Garijo
 */
public class LatexParser {
    private String title;    
    private String abstractSection;

    public LatexParser(String pathFile) {
        try{
            FileInputStream fstream = new FileInputStream(pathFile);
            Scanner fscan = new Scanner(fstream);
            boolean checkingTitle=false, checkingAbstract=false;            
            while(fscan.hasNextLine()){                
                String line = fscan.nextLine();
                if(!line.startsWith("%")){
                    StringTokenizer tok = new StringTokenizer(line);
                    while(tok.hasMoreElements()){
                        String nextData = tok.nextToken();
                        //check for title
                        if(nextData.contains("\\title")){
                            checkingTitle=true;                            
                            title = nextData.replace("\\title{", "")+" ";
                        }
                        else 
                        if(nextData.contains("}") && checkingTitle){                            
                            title+=nextData.split("}")[0];
                            checkingTitle=false;
                        }else if(checkingTitle){
                            title+=nextData+" ";
                        }                        
                        //check for abstract
                        if(nextData.contains("\\begin{abstract}")){
                            checkingAbstract=true;                            
                            abstractSection = nextData.replace("\\begin{abstract}", "")+" ";
                        }
                        else 
                        if(nextData.contains("\\end{abstract}") && checkingAbstract){                            
                            abstractSection+=nextData.replace("\\end{abstract}", "");;
//                            abstractSection.replace("\\end{abstract}", "");//I couldn't figure out why with { it doesn't work
                            checkingAbstract=false;                            
                        }else if(checkingAbstract){
                            abstractSection+=nextData+" ";
                        }
                    }
                }
            }

            fscan.close();
        }catch(Exception e){
            //to do throw some error here
            System.err.println("Error while processing the latex file "+e.getMessage());
        }
    }    
    
    public String getAbstractSection() {
        return abstractSection;
    }


    public String getTitle() {
        return title;
    }
}

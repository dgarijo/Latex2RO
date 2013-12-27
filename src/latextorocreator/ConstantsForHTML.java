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

/**
 * Class declaring the constants of the html web page that will be the RO.
 * This could be considered the template.
 * @author Daniel Garijo
 */
public class ConstantsForHTML {
    /**
     * First part of the head page (until <title> attribute)
     */
    public static String headFirst ="<!DOCTYPE html>\n"+
        "<html class=\"csstransforms no-csstransforms3d csstransitions\" xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\" prefix=\"dc:\n"+ 
        "http://purl.org/dc/terms/ schema: http://schema.org/ prov: http://www.w3.org/ns/prov# ore: http://www.openarchives.org/ore/terms/\n"+ 
        "ro: http://purl.org/wf4ever/ro# opt: http://purl.org/net/RO-optimization# wfprov: http://purl.org/wf4ever/wfprov# wfdesc: http://purl.org/wf4ever/wfdesc#\n"+
        "rdfs: http://www.w3.org/2000/01/rdf-schema#\">\n"+
        "<head>\n"+
        "<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\n"+
        "<meta charset=\"UTF-8\">\n";
    
    /**
     * Second part of the html head. It contains all the css and scripts used.
     */
    public static String headEnd="<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\"></meta>\n"+
        "<link rel=\"stylesheet\" href=\"styles/style.css\" media=\"screen\" />\n"+
        "<link rel=\"stylesheet\" href=\"styles/media-queries.css\" />\n"+
        "<link rel=\"stylesheet\" href=\"./flex-slider/flexslider.css\" type=\"text/css\" media=\"screen\" />\n"+
        "<link href=\"styles/prettyPhoto.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\n"+
        "<link href=\"styles/tipsy.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\n"+

        "<script type=\"text/javascript\" src=\"./scripts/jquery-1.7.1.min.js\"></script>\n"+
        "<script type=\"text/javascript\" src=\"./flex-slider/jquery.flexslider-min.js\"></script>\n"+
        "<script src=\"scripts/jquery.prettyPhoto.js\" type=\"text/javascript\"></script>\n"+
        "<script src=\"scripts/jquery.tipsy.js\" type=\"text/javascript\"></script>\n"+
        "<script src=\"scripts/jquery.knob.js\" type=\"text/javascript\"></script>\n"+
        "<script type=\"text/javascript\" src=\"./scripts/jquery.isotope.min.js\"></script>\n"+
        "<script type=\"text/javascript\" src=\"./scripts/jquery.smooth-scroll.min.js\"></script>\n"+
        "<script type=\"text/javascript\" src=\"./scripts/waypoints.min.js\"></script>\n"+
        "<script type=\"text/javascript\" src=\"./scripts/setup.js\"></script>\n"+

        "<script type=\"text/javascript\" src=\"https://apis.google.com/js/plusone.js\"></script>\n"+

        "</head>\n";
        //"<body resource="http://purl.org/net/ro-motifPaper">";
    /**
     * The first part of the body, until we insert the title.
     */
    public static String bodyFirst = "<body resource=\"\" typeOf=\"ore:Aggregation ro:ResearchObject\">\n"+
         "<span property=\"ore:isDescribedBy\" resource=\"\"></span>\n"+
         "<div id=\"wrap\"> \n"+
         " <!-- wrapper -->\n"+
         " <div id=\"sidebar\"> \n"+
         "   <!-- the  sidebar --> \n"+
         "   <!-- logo -->     \n"+
         "   <!-- navigation menu -->\n"+
         "   <ul id=\"navigation\">\n"+
         "     <li><a href=\"#home\" class=\"active\">Summary</a></li>\n"+
         "     <li id=\"peque\"><a href=\"#abstract\">Abstract</a></li>\n"+
         "         <li id=\"peque\"><a href=\"#inputs\">Inputs and Examples</a></li>\n"+
         "         <li id=\"peque\"><a href=\"#outputs\">Results</a></li>\n"+
         "     <li><a href=\"#auth\">About the authors</a></li>\n"+
         "   </ul>\n"+
         "       <div style=\"bottom:0; position : absolute\">\n"+
         "               <div style=\"float: left; padding-left: 10px; width:110px;\">\n"+
         "               <a href=\"http://www.researchobject.org/\"><img src=\"images/rologo.png\" alt=\"This page is RO enabled\" title=\"This page is described according to the RO Model\" width=\"90px\"></img></a>\n"+
         "               </div>\n"+
         "               <div style=\"float: left\">\n"+
         "               <img src=\"images/rdf.gif\" alt=\"This page is described in rdf-a\" title=\"This page is described in rdf-a\" width=\"90px\"></img>\n"+
         "               </div>\n"+
         "       </div>	\n"+
         " </div>\n"+
         " <div id=\"container\"> \n"+
         "   <!-- page container -->\n"+

         "   <div class=\"page\" id=\"home\"> \n"+
         "     <!-- page home -->\n"+
         "     <div class=\"page_content\">\n"+
         "      <h3  class=\"page_title\" align=\"center\" property=\"dc:title schema:name\">\n";
    /**
     * Second part of the body, until we insert the abstract
     */
    public static String bodySecondAndAbstract="</h3>\n"+
		"<div class=\"space\"> </div>\n"+
		"<div class=\"clear\"> </div>\n"+	
        "<p>\n"+
	"  <br>Here you should write a small introduction about your Research Object: what does it do,\n"+
        "   the paper it describes and where it has been sent (in case it is still under  review. I would also "+
        "recommend to provide a PURL (permanent url) to point to this web page.<br>\n"+
      "</p>\n"+
      "</div> \n"+      
    "</div>\n"+
	"<div class=\"page\" id=\"abstract\">	\n"+
		"<div class=\"page_content\">\n"+
		"<h4 class=\"blue\"> Abstract</h4>\n"+
			"<div class=\"space\"> </div>\n"+
			"<div class=\"clear\"> </div>\n"+
				"<p property=\"dc:abstract\">";
    /**
     * Third part of the body, filling the input and results sections
     */
    public static String bodyThirdAndInputsAndResults="</p>\n"+
        "<div class=\"clear\"> </div>\n"+
        "</div>\n"+
            "</div>\n"+
    "<div class=\"page\" id=\"inputs\"> \n"+
      "<div class=\"page_content\">\n"+
      "<h4  class=\"blue\"> Inputs and examples of the analysis</h4>\n"+
          "<p>You should describe your inputs, approach and examples here. "
            + "If you use datasets or other inputs, explain them here. Also annotate them in rdf-a."
            + "The more you annotate the better your experiment will be able to be reused."+            
      "</div>\n"+
    "</div>\n"+
	"<div class=\"page\" id=\"outputs\">\n"+	
		"<div class=\"page_content\">\n"+
		"<h4 class=\"blue\"> Results of the analysis</h4>\n"
            + "<p>This sections should be used to describe the outputs of you experiment."
            + "If datasets or other resources have been produced, describe (and annotate) them here</p>"+
        "</div>\n"+
    "</div>\n";
    /**
     * Fourth part of the body, until we insert the author info
     */
    public static String bodyFourthAndAboutAuthors ="<div class=\"page\" id=\"auth\">\n"+ 
      "<!-- page industries -->\n"+
      "<div class=\"page_content\">\n"+
      "<h4 class=\"blue\"> About the authors</h4>\n"+      
	"<table>	";
   /**
     * Last part of the html web page
     */
    public static String bodyFifthAndEnd ="</table>\n"+
        "<div class=\"clear\"> </div>\n"+
              "</div>\n"+
            "</div>\n"+

              "<div class=\"page\"> \n"+
              "<!-- page industries -->	\n"+
                  "<div class=\"page_content\">\n"+
              "<h4 class=\"blue\">Acknowledgements</h4>\n"+
                        "Insert acknowledgemnts here if appropriate\n"+
              "<div class=\"clear\"> </div>\n"+
            "</div> \n"+
           "<br>\n"+
            "<div class=\"page\" align=\"center\">\n"+
            "<a rel=\"license\" href=\"http://creativecommons.org/licenses/by-nc-sa/2.0/\"><img alt=\"Creative Commons License\" style=\"border-width:0\" src=\"http://i.creativecommons.org/l/by-nc-sa/2.0/88x31.png\" /></a><br />This page is licensed under a <a rel=\"license\" href=\"http://creativecommons.org/licenses/by-nc-sa/2.0/\">Creative Commons Attribution-NonCommercial-ShareAlike 2.0 Generic License</a>.\n"+
            "</div>\n"+
          "</div>\n"+
        "<a class=\"gotop hidden\" href=\"#top\">Top</a>\n"+
        "</body></html>";    
}

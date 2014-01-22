Latex2RO
=====================

The Latex2RO Creator is a simple tool designed to help creating Research Objects (ROs) from LaTeX papers. Given a LaTeX file, the RO creator will extract its title and metadata and fill partially a structured HTML page annotated in RDF-a with these metadata. The HTML page can then be completed and annotated by the user providing the links to the rest of the resources used in the Research Object.

You can see an example of an output page here: http://http://purl.org/net/svm-opt-research-object
Requirements
===
In order to use this tool, you should know the basic notions of RDF-a and HTML (if you want to further complete the initial annotations).

Usage
===
You can use the tool in two different ways:
* With console (you can find the jar in the executable-console folder): Use it with the command: java -jar ROCreator.java -s ResearchObjectSavePath [-l latexFilePath} [-c CreatorName_CreatorSurname] 
* With a GUI (you can find the jar in the executable-gui folder): Double click on the file and follow the instructions of the application.  

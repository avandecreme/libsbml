/**
 * Example, reading an SBML file containing an element with provided 
 * meta id, reading a raw annoation from a file, and adding it to the 
 * element. 
 * 
 */

#include <iostream>
#include <sbml/SBMLTypes.h>

using namespace std;
LIBSBML_CPP_NAMESPACE_USE

XMLNode* parseAnnotation(const std::string& annotationFile)
{
	// read file into memory
	FILE* file = fopen(annotationFile.c_str(), "r");
	fseek(file, 0, SEEK_END);
	long length = ftell(file);

	fseek(file, 0, SEEK_SET);
	char* data = new char[length + 1];
	
	// fill data with zeros
	memset(data, 0, length + 1);

	fread(data, 1, length, file);
	fclose(file);
	data[length] = '\0';

	// parse the string
	XMLNode* xmlnode = XMLNode::convertStringToXMLNode(data);
	delete[] data;
	return xmlnode;
}

bool setAnnotation(const std::string& sbmlFile, const std::string& metaId,
	const std::string& annotationFile, const std::string& outputFile)
{
	auto *document = readSBML(sbmlFile.c_str());
	if (document->getNumErrors(LIBSBML_SEV_ERROR) > 0)
	{
		cerr << "Encountered the following SBML errors:" << std::endl;
		document->printErrors();
		return false;
	}
	
	auto* element = document->getElementByMetaId(metaId);
	if (!element)
	{
		cerr << "No element with meta id " << metaId << " found." << std::endl;
		return false;
	}

	auto annotation = parseAnnotation(annotationFile);
	if (!annotation)
	{
		cerr << "the annotation could not be parsed from file: " << annotationFile << "." << std::endl;
		return false;
	}
	auto annotationString = annotation->toXMLString();
	element->setAnnotation(annotation, false);

	// at this point we'd expect the annotation to be set precisely to what it was 
	// in the file.

	
	auto resultingAnnotation = element->getAnnotationString();

	if (annotationString != resultingAnnotation)
	{
		cerr << "Annotation was not set correctly." << std::endl;
		return false;
	}

	// write document to output file
	writeSBMLToFile(document, outputFile.c_str());

	delete document;

	return true;
}

int main(int argc, char* argv[])
{
	std::string sbmlFile;
	std::string metaId;
	std::string annotationFile;
	std::string outputFile;

	if (argc != 5)
	{
		cout << endl
				 << "  usage: setAnnotaion <input-filename> <element-meta-id> <annotation-file> <output-file>" << endl
				 << "  Adds controlled vocabulary term to a species"          << endl
				 << endl;
		return 1;


		//sbmlFile = "bm190.xml";
		//annotationFile = "annotation.xml";
		//metaId = "metaid_0000036";
		//outputFile = "bm190_out.xml";

	}
	else
	{
		sbmlFile = argv[1];
		metaId = argv[2];
		annotationFile = argv[3];
		outputFile = argv[4];
	}

	setAnnotation(sbmlFile, metaId, annotationFile, outputFile);
}
/**
 * @file    readSBML.c
 * @brief   Similar to validateSBML, but without the validation
 * @author  Ben Bornstein
 *
 * <!--------------------------------------------------------------------------
 * This sample program is distributed under a different license than the rest
 * of libSBML.  This program uses the open-source MIT license, as follows:
 *
 * Copyright (c) 2013-2018 by the California Institute of Technology
 * (California, USA), the European Bioinformatics Institute (EMBL-EBI, UK)
 * and the University of Heidelberg (Germany), with support from the National
 * Institutes of Health (USA) under grant R01GM070923.  All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 * Neither the name of the California Institute of Technology (Caltech), nor
 * of the European Bioinformatics Institute (EMBL-EBI), nor of the University
 * of Heidelberg, nor the names of any contributors, may be used to endorse
 * or promote products derived from this software without specific prior
 * written permission.
 * ------------------------------------------------------------------------ -->
 */

#include <stdio.h>

#include <sbml/SBMLTypes.h>
#include <sbml/conversion/ConversionProperties.h>
// #include "util.h"


int
main (int argc, char *argv[])
{
  const char *filename;

#ifdef __BORLANDC__
  unsigned long start, stop, size;
#else
  unsigned long long start, stop, size;
#endif
  unsigned int       errors;

  SBMLDocument_t *doc;


  if (argc != 2)
  {
    printf("Usage: readSBML filename\n");
    return 2;
  }


  filename = argv[1];

  // start = getCurrentMillis();
  doc     = readSBML(filename);
  // stop  = getCurrentMillis();

  errors = SBMLDocument_getNumErrors(doc);
  // size   = getFileSize(filename);

  printf( "\n" );
  printf( "        filename: %s\n" , filename     );
  // printf( "       file size: %llu\n", size         );
  // printf( "  read time (ms): %llu\n", stop - start );
  printf( "        error(s): %u\n" , errors       );

  if (errors > 0) SBMLDocument_printErrors(doc, stdout);
  printf("\n");

  ConversionProperties_t* props;
  ConversionOption_t* option;

  props = ConversionProperties_create();
  option = ConversionOption_create("inferUnits");
  ConversionProperties_addOption(props, option);
  unsigned int err = SBMLDocument_convert(doc, props);

  printf("Got conversion error code: %i\n", err);

  Model_t *m = SBMLDocument_getModel(doc);
  for (unsigned int i = 0; i < Model_getNumParameters(m); i++) {
    Parameter_t *p = Model_getParameter(m, i);
    printf("Param %i has unit %s", i, Parameter_getUnits(p));
  }

  SBMLDocument_free(doc);
  return errors;
}



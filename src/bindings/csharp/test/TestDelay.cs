/// 
///  @file    TestDelay.cs
///  @brief   SBML Delay unit tests
///  @author  Frank Bergmann (Csharp conversion)
///  @author  Akiya Jouraku (Csharp conversion)
///  @author  Sarah Keating 
/// 
///  $Id$
///  $URL$
/// 
///  This test file was converted from src/sbml/test/TestDelay.c
///  with the help of conversion sciprt (ctest_converter.pl).
/// 
/// <!---------------------------------------------------------------------------
///  This file is part of libSBML.  Please visit http://sbml.org for more
///  information about SBML, and the latest version of libSBML.
/// 
///  Copyright 2005-2008 California Institute of Technology.
///  Copyright 2002-2005 California Institute of Technology and
///                      Japan Science and Technology Corporation.
///  
///  This library is free software; you can redistribute it and/or modify it
///  under the terms of the GNU Lesser General Public License as published by
///  the Free Software Foundation.  A copy of the license agreement is provided
///  in the file named "LICENSE.txt" included with this software distribution
///  and also available online as http://sbml.org/software/libsbml/license.html
/// --------------------------------------------------------------------------->*/


namespace LibSBMLCSTest {

  using libsbml;

  using  System.IO;

  public class TestDelay {
    public class AssertionError : System.Exception 
    {
      public AssertionError() : base()
      {
        
      }
    }


    static void assertTrue(bool condition)
    {
      if (condition == true)
      {
        return;
      }
      throw new AssertionError();
    }

    static void assertEquals(object a, object b)
    {
      if ( (a == null) && (b == null) )
      {
        return;
      }
      else if (a.Equals(b))
      {
        return;
      }
  
      throw new AssertionError();
    }

    static void assertNotEquals(object a, object b)
    {
      if ( (a == null) && (b == null) )
      {
        throw new AssertionError();
      }
      else if (a.Equals(b))
      {
        throw new AssertionError();
      }
    }

    static void assertEquals(bool a, bool b)
    {
      if ( a == b )
      {
        return;
      }
      throw new AssertionError();
    }

    static void assertNotEquals(bool a, bool b)
    {
      if ( a != b )
      {
        return;
      }
      throw new AssertionError();
    }

    static void assertEquals(int a, int b)
    {
      if ( a == b )
      {
        return;
      }
      throw new AssertionError();
    }

    static void assertNotEquals(int a, int b)
    {
      if ( a != b )
      {
        return;
      }
      throw new AssertionError();
    }

    private Delay D;

    public void setUp()
    {
      D = new  Delay();
      if (D == null);
      {
      }
    }

    public void tearDown()
    {
      D = null;
    }

    public void test_Delay_create()
    {
      assertTrue( D.getTypeCode() == libsbml.SBML_DELAY );
      assertTrue( D.getMetaId()== "" == true );
      assertTrue( D.getNotes() == null );
      assertTrue( D.getAnnotation() == null );
      assertTrue( D.getMath() == null );
    }

    public void test_Delay_createWithMath()
    {
      ASTNode math = libsbml.parseFormula("x^3");
      Delay fd = new  Delay(math);
      ASTNode math1;
      string formula;
      assertTrue( fd.getTypeCode() == libsbml.SBML_DELAY );
      assertTrue( fd.getMetaId()== "" == true );
      assertTrue( fd.getNotes() == null );
      assertTrue( fd.getAnnotation() == null );
      math1 = fd.getMath();
      assertTrue( math1 != null );
      formula = libsbml.formulaToString(math1);
      assertTrue( formula != null );
      assertTrue((  "x^3" == formula ));
      assertTrue( fd.getMath() != math );
      assertEquals( true, fd.isSetMath() );
      fd = null;
    }

    public void test_Delay_free_NULL()
    {
    }

    public void test_Delay_setMath()
    {
      ASTNode math = libsbml.parseFormula("lambda(x, x^3)");
      ASTNode math1;
      string formula;
      D.setMath(math);
      math1 = D.getMath();
      assertTrue( math1 != null );
      formula = libsbml.formulaToString(math1);
      assertTrue( formula != null );
      assertTrue((  "lambda(x, x^3)" == formula ));
      assertTrue( D.getMath() != math );
      assertEquals( true, D.isSetMath() );
      D.setMath(D.getMath());
      math1 = D.getMath();
      assertTrue( math1 != null );
      formula = libsbml.formulaToString(math1);
      assertTrue( formula != null );
      assertTrue((  "lambda(x, x^3)" == formula ));
      D.setMath(null);
      assertEquals( false, D.isSetMath() );
      if (D.getMath() != null);
      {
      }
    }

  }
}

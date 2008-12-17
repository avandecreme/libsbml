/// 
///  @file    TestReadFromFile2.cs
///  @brief   Reads tests/l1v1-units.xml into memory and tests it.
///  @author  Frank Bergmann (Csharp conversion)
///  @author  Akiya Jouraku (Csharp conversion)
///  @author  Ben Bornstein 
/// 
///  $Id$
///  $URL$
/// 
///  This test file was converted from src/sbml/test/TestReadFromFile2.c
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

  public class TestReadFromFile2 {
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


    public void test_create_l1v1_units()
    {
      SBMLDocument d;
      Model m;
      Compartment c;
      KineticLaw kl;
      Parameter p;
      Reaction r;
      Species s;
      SpeciesReference sr;
      Unit u;
      UnitDefinition ud;
      d = new  SBMLDocument();
      m = new  Model();
      d.setModel(m);
      ud = m.createUnitDefinition();
      ud.setName( "substance");
      u = m.createUnit();
      u.setKind(libsbml.UNIT_KIND_MOLE);
      u.setScale(-3);
      ud = m.createUnitDefinition();
      ud.setName( "mls");
      u = m.createUnit();
      u.setKind(libsbml.UNIT_KIND_MOLE);
      u.setScale(-3);
      u = m.createUnit();
      u.setKind(libsbml.UNIT_KIND_LITER);
      u.setExponent(-1);
      u = m.createUnit();
      u.setKind(libsbml.UNIT_KIND_SECOND);
      u.setExponent(-1);
      c = m.createCompartment();
      c.setName( "cell");
      s = m.createSpecies();
      s.setName( "x0");
      s.setCompartment( "cell");
      s.setInitialAmount(1);
      s = m.createSpecies();
      s.setName( "x1");
      s.setCompartment( "cell");
      s.setInitialAmount(1);
      s = m.createSpecies();
      s.setName( "s1");
      s.setCompartment( "cell");
      s.setInitialAmount(1);
      s = m.createSpecies();
      s.setName( "s2");
      s.setCompartment( "cell");
      s.setInitialAmount(1);
      p = m.createParameter();
      p.setName( "vm");
      p.setUnits( "mls");
      p.setValue(2);
      p = m.createParameter();
      p.setName( "km");
      p.setValue(2);
      r = m.createReaction();
      r.setName( "v1");
      sr = m.createReactant();
      sr.setSpecies( "x0");
      sr = m.createProduct();
      sr.setSpecies( "s1");
      kl = m.createKineticLaw();
      kl.setFormula( "(vm * s1)/(km + s1)");
      r = m.createReaction();
      r.setName( "v2");
      sr = m.createReactant();
      sr.setSpecies( "s1");
      sr = m.createProduct();
      sr.setSpecies( "s2");
      kl = m.createKineticLaw();
      kl.setFormula( "(vm * s2)/(km + s2)");
      r = m.createReaction();
      r.setName( "v3");
      sr = m.createReactant();
      sr.setSpecies( "s2");
      sr = m.createProduct();
      sr.setSpecies( "x1");
      kl = m.createKineticLaw();
      kl.setFormula( "(vm * s1)/(km + s1)");
      d = null;
    }

    public void test_read_l1v1_units()
    {
      SBMLDocument d;
      Model m;
      Compartment c;
      KineticLaw kl;
      Parameter p;
      Reaction r;
      Species s;
      SpeciesReference sr;
      Unit u;
      UnitDefinition ud;
      string filename = "../../sbml/test/test-data/l1v1-units.xml";
      d = libsbml.readSBML(filename);
      if (d == null);
      {
      }
      assertTrue( d.getLevel() == 1 );
      assertTrue( d.getVersion() == 1 );
      m = d.getModel();
      assertTrue( m.getNumUnitDefinitions() == 2 );
      ud = m.getUnitDefinition(0);
      assertTrue((  "substance" == ud.getName() ));
      ud = m.getUnitDefinition(1);
      assertTrue((  "mls" == ud.getName() ));
      ud = m.getUnitDefinition(0);
      assertTrue( ud.getNumUnits() == 1 );
      u = ud.getUnit(0);
      assertTrue( u.getKind() == libsbml.UNIT_KIND_MOLE );
      assertTrue( u.getExponent() == 1 );
      assertTrue( u.getScale() == -3 );
      ud = m.getUnitDefinition(1);
      assertTrue( ud.getNumUnits() == 3 );
      u = ud.getUnit(0);
      assertTrue( u.getKind() == libsbml.UNIT_KIND_MOLE );
      assertTrue( u.getExponent() == 1 );
      assertTrue( u.getScale() == -3 );
      u = ud.getUnit(1);
      assertTrue( u.getKind() == libsbml.UNIT_KIND_LITER );
      assertTrue( u.getExponent() == -1 );
      assertTrue( u.getScale() == 0 );
      u = ud.getUnit(2);
      assertTrue( u.getKind() == libsbml.UNIT_KIND_SECOND );
      assertTrue( u.getExponent() == -1 );
      assertTrue( u.getScale() == 0 );
      assertTrue( m.getNumCompartments() == 1 );
      c = m.getCompartment(0);
      assertTrue((  "cell" == c.getName() ));
      assertTrue( m.getNumSpecies() == 4 );
      s = m.getSpecies(0);
      assertTrue((  "x0"    == s.getName() ));
      assertTrue((  "cell"  == s.getCompartment() ));
      assertTrue( s.getInitialAmount() == 1 );
      assertTrue( s.getBoundaryCondition() == false );
      ud = s.getDerivedUnitDefinition();
      assertTrue( ud.getNumUnits() == 2 );
      assertTrue( ud.getUnit(0).getKind() == libsbml.UNIT_KIND_MOLE );
      assertTrue( ud.getUnit(0).getExponent() == 1 );
      assertTrue( ud.getUnit(0).getScale() == -3 );
      assertTrue( ud.getUnit(1).getKind() == libsbml.UNIT_KIND_LITRE );
      assertTrue( ud.getUnit(1).getExponent() == -1 );
      s = m.getSpecies(1);
      assertTrue((  "x1"    == s.getName() ));
      assertTrue((  "cell"  == s.getCompartment() ));
      assertTrue( s.getInitialAmount() == 1 );
      assertTrue( s.getBoundaryCondition() == false );
      s = m.getSpecies(2);
      assertTrue((  "s1"    == s.getName() ));
      assertTrue((  "cell"  == s.getCompartment() ));
      assertTrue( s.getInitialAmount() == 1 );
      assertTrue( s.getBoundaryCondition() == false );
      s = m.getSpecies(3);
      assertTrue((  "s2"    == s.getName() ));
      assertTrue((  "cell"  == s.getCompartment() ));
      assertTrue( s.getInitialAmount() == 1 );
      assertTrue( s.getBoundaryCondition() == false );
      assertTrue( m.getNumParameters() == 2 );
      p = m.getParameter(0);
      assertTrue((  "vm"   == p.getName() ));
      assertTrue((  "mls"  == p.getUnits() ));
      assertTrue( p.getValue() == 2 );
      ud = p.getDerivedUnitDefinition();
      assertTrue( ud.getNumUnits() == 3 );
      assertTrue( ud.getUnit(0).getKind() == libsbml.UNIT_KIND_MOLE );
      assertTrue( ud.getUnit(0).getExponent() == 1 );
      assertTrue( ud.getUnit(0).getScale() == -3 );
      assertTrue( ud.getUnit(1).getKind() == libsbml.UNIT_KIND_LITER );
      assertTrue( ud.getUnit(1).getExponent() == -1 );
      assertTrue( ud.getUnit(2).getKind() == libsbml.UNIT_KIND_SECOND );
      assertTrue( ud.getUnit(2).getExponent() == -1 );
      p = m.getParameter(1);
      assertTrue((  "km"   == p.getName() ));
      assertTrue( p.getValue() == 2 );
      ud = p.getDerivedUnitDefinition();
      assertTrue( ud.getNumUnits() == 0 );
      assertTrue( m.getNumReactions() == 3 );
      r = m.getReaction(0);
      assertTrue((  "v1" == r.getName() ));
      assertTrue( r.getReversible() != false );
      assertTrue( r.getFast() == false );
      r = m.getReaction(1);
      assertTrue((  "v2" == r.getName() ));
      assertTrue( r.getReversible() != false );
      assertTrue( r.getFast() == false );
      r = m.getReaction(2);
      assertTrue((  "v3" == r.getName() ));
      assertTrue( r.getReversible() != false );
      assertTrue( r.getFast() == false );
      r = m.getReaction(0);
      assertTrue( r.getNumReactants() == 1 );
      assertTrue( r.getNumProducts() == 1 );
      sr = r.getReactant(0);
      assertTrue((  "x0" == sr.getSpecies() ));
      assertTrue( sr.getStoichiometry() == 1 );
      assertTrue( sr.getDenominator() == 1 );
      sr = r.getProduct(0);
      assertTrue((  "s1" == sr.getSpecies() ));
      assertTrue( sr.getStoichiometry() == 1 );
      assertTrue( sr.getDenominator() == 1 );
      kl = r.getKineticLaw();
      assertTrue((  "cell * (vm * s1)/(km + s1)" == kl.getFormula() ));
      r = m.getReaction(1);
      assertTrue( r.getNumReactants() == 1 );
      assertTrue( r.getNumProducts() == 1 );
      sr = r.getReactant(0);
      assertTrue((  "s1" == sr.getSpecies() ));
      assertTrue( sr.getStoichiometry() == 1 );
      assertTrue( sr.getDenominator() == 1 );
      sr = r.getProduct(0);
      assertTrue((  "s2" == sr.getSpecies() ));
      assertTrue( sr.getStoichiometry() == 1 );
      assertTrue( sr.getDenominator() == 1 );
      kl = r.getKineticLaw();
      assertTrue((  "cell * (vm * s2)/(km + s2)" == kl.getFormula() ));
      r = m.getReaction(2);
      assertTrue( r.getNumReactants() == 1 );
      assertTrue( r.getNumProducts() == 1 );
      sr = r.getReactant(0);
      assertTrue((  "s2" == sr.getSpecies() ));
      assertTrue( sr.getStoichiometry() == 1 );
      assertTrue( sr.getDenominator() == 1 );
      sr = r.getProduct(0);
      assertTrue((  "x1" == sr.getSpecies() ));
      assertTrue( sr.getStoichiometry() == 1 );
      assertTrue( sr.getDenominator() == 1 );
      kl = r.getKineticLaw();
      assertTrue((  "cell * (vm * s1)/(km + s1)" == kl.getFormula() ));
      d = null;
    }

  }
}

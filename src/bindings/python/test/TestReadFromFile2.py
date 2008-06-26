#
# @file    TestReadFromFile2.py
# @brief   Reads tests/l1v1-units.xml into memory and tests it.
# @author  Akiya Jouraku (Python conversion)
# @author  Ben Bornstein 
#
# $Id$
# $HeadURL$
#
# This test file was converted from src/sbml/test/TestReadFromFile2.c
# with the help of conversion sciprt (ctest_converter.pl).
#
#<!---------------------------------------------------------------------------
# This file is part of libSBML.  Please visit http://sbml.org for more
# information about SBML, and the latest version of libSBML.
#
# Copyright 2005-2008 California Institute of Technology.
# Copyright 2002-2005 California Institute of Technology and
#                     Japan Science and Technology Corporation.
# 
# This library is free software; you can redistribute it and/or modify it
# under the terms of the GNU Lesser General Public License as published by
# the Free Software Foundation.  A copy of the license agreement is provided
# in the file named "LICENSE.txt" included with this software distribution
# and also available online as http://sbml.org/software/libsbml/license.html
#--------------------------------------------------------------------------->*/
import sys
import unittest
import libsbml

class TestReadFromFile2(unittest.TestCase):


  def test_create_l1v1_units(self):
    d = libsbml.SBMLDocument()
    m = libsbml.Model()
    d.setModel(m)
    ud = m.createUnitDefinition()
    ud.setName( "substance")
    u = m.createUnit()
    u.setKind(libsbml.UNIT_KIND_MOLE)
    u.setScale(-3)
    ud = m.createUnitDefinition()
    ud.setName( "mls")
    u = m.createUnit()
    u.setKind(libsbml.UNIT_KIND_MOLE)
    u.setScale(-3)
    u = m.createUnit()
    u.setKind(libsbml.UNIT_KIND_LITER)
    u.setExponent(-1)
    u = m.createUnit()
    u.setKind(libsbml.UNIT_KIND_SECOND)
    u.setExponent(-1)
    c = m.createCompartment()
    c.setName( "cell")
    s = m.createSpecies()
    s.setName( "x0")
    s.setCompartment( "cell")
    s.setInitialAmount(1)
    s = m.createSpecies()
    s.setName( "x1")
    s.setCompartment( "cell")
    s.setInitialAmount(1)
    s = m.createSpecies()
    s.setName( "s1")
    s.setCompartment( "cell")
    s.setInitialAmount(1)
    s = m.createSpecies()
    s.setName( "s2")
    s.setCompartment( "cell")
    s.setInitialAmount(1)
    p = m.createParameter()
    p.setName( "vm")
    p.setUnits( "mls")
    p.setValue(2)
    p = m.createParameter()
    p.setName( "km")
    p.setValue(2)
    r = m.createReaction()
    r.setName( "v1")
    sr = m.createReactant()
    sr.setSpecies( "x0")
    sr = m.createProduct()
    sr.setSpecies( "s1")
    kl = m.createKineticLaw()
    kl.setFormula( "(vm * s1)/(km + s1)")
    r = m.createReaction()
    r.setName( "v2")
    sr = m.createReactant()
    sr.setSpecies( "s1")
    sr = m.createProduct()
    sr.setSpecies( "s2")
    kl = m.createKineticLaw()
    kl.setFormula( "(vm * s2)/(km + s2)")
    r = m.createReaction()
    r.setName( "v3")
    sr = m.createReactant()
    sr.setSpecies( "s2")
    sr = m.createProduct()
    sr.setSpecies( "x1")
    kl = m.createKineticLaw()
    kl.setFormula( "(vm * s1)/(km + s1)")
    d = None
    pass  

  def test_read_l1v1_units(self):
    filename = "../../sbml/test/test-data/l1v1-units.xml"
    d = libsbml.readSBML(filename)
    if (d == None):
      pass    
    self.assert_( d.getLevel() == 1 )
    self.assert_( d.getVersion() == 1 )
    m = d.getModel()
    self.assert_( m.getNumUnitDefinitions() == 2 )
    ud = m.getUnitDefinition(0)
    self.assert_((  "substance" == ud.getName() ))
    ud = m.getUnitDefinition(1)
    self.assert_((  "mls" == ud.getName() ))
    ud = m.getUnitDefinition(0)
    self.assert_( ud.getNumUnits() == 1 )
    u = ud.getUnit(0)
    self.assert_( u.getKind() == libsbml.UNIT_KIND_MOLE )
    self.assert_( u.getExponent() == 1 )
    self.assert_( u.getScale() == -3 )
    ud = m.getUnitDefinition(1)
    self.assert_( ud.getNumUnits() == 3 )
    u = ud.getUnit(0)
    self.assert_( u.getKind() == libsbml.UNIT_KIND_MOLE )
    self.assert_( u.getExponent() == 1 )
    self.assert_( u.getScale() == -3 )
    u = ud.getUnit(1)
    self.assert_( u.getKind() == libsbml.UNIT_KIND_LITER )
    self.assert_( u.getExponent() == -1 )
    self.assert_( u.getScale() == 0 )
    u = ud.getUnit(2)
    self.assert_( u.getKind() == libsbml.UNIT_KIND_SECOND )
    self.assert_( u.getExponent() == -1 )
    self.assert_( u.getScale() == 0 )
    self.assert_( m.getNumCompartments() == 1 )
    c = m.getCompartment(0)
    self.assert_((  "cell" == c.getName() ))
    self.assert_( m.getNumSpecies() == 4 )
    s = m.getSpecies(0)
    self.assert_((  "x0"    == s.getName() ))
    self.assert_((  "cell"  == s.getCompartment() ))
    self.assert_( s.getInitialAmount() == 1 )
    self.assert_( s.getBoundaryCondition() == False )
    ud = s.getDerivedUnitDefinition()
    self.assert_( ud.getNumUnits() == 2 )
    self.assert_( ud.getUnit(0).getKind() == libsbml.UNIT_KIND_MOLE )
    self.assert_( ud.getUnit(0).getExponent() == 1 )
    self.assert_( ud.getUnit(0).getScale() == -3 )
    self.assert_( ud.getUnit(1).getKind() == libsbml.UNIT_KIND_LITRE )
    self.assert_( ud.getUnit(1).getExponent() == -1 )
    s = m.getSpecies(1)
    self.assert_((  "x1"    == s.getName() ))
    self.assert_((  "cell"  == s.getCompartment() ))
    self.assert_( s.getInitialAmount() == 1 )
    self.assert_( s.getBoundaryCondition() == False )
    s = m.getSpecies(2)
    self.assert_((  "s1"    == s.getName() ))
    self.assert_((  "cell"  == s.getCompartment() ))
    self.assert_( s.getInitialAmount() == 1 )
    self.assert_( s.getBoundaryCondition() == False )
    s = m.getSpecies(3)
    self.assert_((  "s2"    == s.getName() ))
    self.assert_((  "cell"  == s.getCompartment() ))
    self.assert_( s.getInitialAmount() == 1 )
    self.assert_( s.getBoundaryCondition() == False )
    self.assert_( m.getNumParameters() == 2 )
    p = m.getParameter(0)
    self.assert_((  "vm"   == p.getName() ))
    self.assert_((  "mls"  == p.getUnits() ))
    self.assert_( p.getValue() == 2 )
    ud = p.getDerivedUnitDefinition()
    self.assert_( ud.getNumUnits() == 3 )
    self.assert_( ud.getUnit(0).getKind() == libsbml.UNIT_KIND_MOLE )
    self.assert_( ud.getUnit(0).getExponent() == 1 )
    self.assert_( ud.getUnit(0).getScale() == -3 )
    self.assert_( ud.getUnit(1).getKind() == libsbml.UNIT_KIND_LITER )
    self.assert_( ud.getUnit(1).getExponent() == -1 )
    self.assert_( ud.getUnit(2).getKind() == libsbml.UNIT_KIND_SECOND )
    self.assert_( ud.getUnit(2).getExponent() == -1 )
    p = m.getParameter(1)
    self.assert_((  "km"   == p.getName() ))
    self.assert_( p.getValue() == 2 )
    ud = p.getDerivedUnitDefinition()
    self.assert_( ud.getNumUnits() == 0 )
    self.assert_( m.getNumReactions() == 3 )
    r = m.getReaction(0)
    self.assert_((  "v1" == r.getName() ))
    self.assert_( r.getReversible() != False )
    self.assert_( r.getFast() == False )
    r = m.getReaction(1)
    self.assert_((  "v2" == r.getName() ))
    self.assert_( r.getReversible() != False )
    self.assert_( r.getFast() == False )
    r = m.getReaction(2)
    self.assert_((  "v3" == r.getName() ))
    self.assert_( r.getReversible() != False )
    self.assert_( r.getFast() == False )
    r = m.getReaction(0)
    self.assert_( r.getNumReactants() == 1 )
    self.assert_( r.getNumProducts() == 1 )
    sr = r.getReactant(0)
    self.assert_((  "x0" == sr.getSpecies() ))
    self.assert_( sr.getStoichiometry() == 1 )
    self.assert_( sr.getDenominator() == 1 )
    sr = r.getProduct(0)
    self.assert_((  "s1" == sr.getSpecies() ))
    self.assert_( sr.getStoichiometry() == 1 )
    self.assert_( sr.getDenominator() == 1 )
    kl = r.getKineticLaw()
    self.assert_((  "cell * (vm * s1)/(km + s1)" == kl.getFormula() ))
    r = m.getReaction(1)
    self.assert_( r.getNumReactants() == 1 )
    self.assert_( r.getNumProducts() == 1 )
    sr = r.getReactant(0)
    self.assert_((  "s1" == sr.getSpecies() ))
    self.assert_( sr.getStoichiometry() == 1 )
    self.assert_( sr.getDenominator() == 1 )
    sr = r.getProduct(0)
    self.assert_((  "s2" == sr.getSpecies() ))
    self.assert_( sr.getStoichiometry() == 1 )
    self.assert_( sr.getDenominator() == 1 )
    kl = r.getKineticLaw()
    self.assert_((  "cell * (vm * s2)/(km + s2)" == kl.getFormula() ))
    r = m.getReaction(2)
    self.assert_( r.getNumReactants() == 1 )
    self.assert_( r.getNumProducts() == 1 )
    sr = r.getReactant(0)
    self.assert_((  "s2" == sr.getSpecies() ))
    self.assert_( sr.getStoichiometry() == 1 )
    self.assert_( sr.getDenominator() == 1 )
    sr = r.getProduct(0)
    self.assert_((  "x1" == sr.getSpecies() ))
    self.assert_( sr.getStoichiometry() == 1 )
    self.assert_( sr.getDenominator() == 1 )
    kl = r.getKineticLaw()
    self.assert_((  "cell * (vm * s1)/(km + s1)" == kl.getFormula() ))
    d = None
    pass  

def suite():
  suite = unittest.TestSuite()
  suite.addTest(unittest.makeSuite(TestReadFromFile2))

  return suite

if __name__ == "__main__":
  if unittest.TextTestRunner(verbosity=1).run(suite()).wasSuccessful() :
    sys.exit(0)
  else:
    sys.exit(1)

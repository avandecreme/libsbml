/*
 *
 * @file    TestAncestor.java
 * @brief   SBML ancestor objects unit tests
 *
 * @author  Akiya Jouraku (Java conversion)
 * @author  Sarah Keating 
 *
 * $Id$
 * $URL$
 *
 * This test file was converted from src/sbml/test/TestAncestor.cpp
 * with the help of conversion sciprt (ctest_converter.pl).
 *
 *<!---------------------------------------------------------------------------
 * This file is part of libSBML.  Please visit http://sbml.org for more
 * information about SBML, and the latest version of libSBML.
 *
 * Copyright 2005-2008 California Institute of Technology.
 * Copyright 2002-2005 California Institute of Technology and
 *                     Japan Science and Technology Corporation.
 * 
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation.  A copy of the license agreement is provided
 * in the file named "LICENSE.txt" included with this software distribution
 * and also available online as http://sbml.org/software/libsbml/license.html
 *--------------------------------------------------------------------------->*/


package org.sbml.libsbml.test;

import org.sbml.libsbml.*;

import java.io.File;
import java.lang.AssertionError;

public class TestAncestor {

  static void assertTrue(boolean condition) throws AssertionError
  {
    if (condition == true)
    {
      return;
    }
    throw new AssertionError();
  }

  static void assertEquals(Object a, Object b) throws AssertionError
  {
    if ( (a == null) && (b == null) )
    {
      return;
    }
    else if (a.equals(b))
    {
      return;
    }

    throw new AssertionError();
  }

  static void assertNotEquals(Object a, Object b) throws AssertionError
  {
    if ( (a == null) && (b == null) )
    {
      throw new AssertionError();
    }
    else if (a.equals(b))
    {
      throw new AssertionError();
    }
  }

  static void assertEquals(boolean a, boolean b) throws AssertionError
  {
    if ( a == b )
    {
      return;
    }
    throw new AssertionError();
  }

  static void assertNotEquals(boolean a, boolean b) throws AssertionError
  {
    if ( a != b )
    {
      return;
    }
    throw new AssertionError();
  }

  static void assertEquals(int a, int b) throws AssertionError
  {
    if ( a == b )
    {
      return;
    }
    throw new AssertionError();
  }

  static void assertNotEquals(int a, int b) throws AssertionError
  {
    if ( a != b )
    {
      return;
    }
    throw new AssertionError();
  }

  public void test_AlgebraicRule_ancestor_create()
  {
    Model m = new Model();
    AlgebraicRule r = m.createAlgebraicRule();
    ListOf lo = m.getListOfRules();
    assertEquals( r.getAncestorOfType(libsbml.SBML_MODEL) , m );
    assertEquals( r.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( r.getAncestorOfType(libsbml.SBML_DOCUMENT) , null );
    assertEquals( r.getAncestorOfType(libsbml.SBML_EVENT) , null );
    Rule obj = m.getRule(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL) , m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT) , null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT) , null );
  }

  public void test_AssignmentRule_ancestor_create()
  {
    Model m = new Model();
    AssignmentRule r = m.createAssignmentRule();
    ListOf lo = m.getListOfRules();
    assertEquals( r.getAncestorOfType(libsbml.SBML_MODEL) , m );
    assertEquals( r.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( r.getAncestorOfType(libsbml.SBML_DOCUMENT) , null );
    assertEquals( r.getAncestorOfType(libsbml.SBML_EVENT) , null );
    Rule obj = m.getRule(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL) , m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT) , null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT) , null );
  }

  public void test_CompartmentType_ancestor_add()
  {
    CompartmentType ct = new CompartmentType();
    Model m = new Model();
    m.addCompartmentType(ct);
    ct = null;
    ListOf lo = m.getListOfCompartmentTypes();
    CompartmentType obj = m.getCompartmentType(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL) , m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT) , null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT) , null );
  }

  public void test_CompartmentType_ancestor_create()
  {
    Model m = new Model();
    CompartmentType ct = m.createCompartmentType();
    ListOf lo = m.getListOfCompartmentTypes();
    assertEquals( ct.getAncestorOfType(libsbml.SBML_MODEL) , m );
    assertEquals( ct.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( ct.getAncestorOfType(libsbml.SBML_DOCUMENT) , null );
    assertEquals( ct.getAncestorOfType(libsbml.SBML_EVENT) , null );
    CompartmentType obj = m.getCompartmentType(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL) , m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT) , null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT) , null );
  }

  public void test_Compartment_ancestor_add()
  {
    Compartment c = new Compartment();
    Model m = new Model();
    m.addCompartment(c);
    c = null;
    ListOf lo = m.getListOfCompartments();
    Compartment obj = m.getCompartment(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL) , m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT) , null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT) , null );
  }

  public void test_Compartment_ancestor_create()
  {
    Model m = new Model();
    Compartment c = m.createCompartment();
    ListOf lo = m.getListOfCompartments();
    assertEquals( c.getAncestorOfType(libsbml.SBML_MODEL) , m );
    assertEquals( c.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( c.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( c.getAncestorOfType(libsbml.SBML_EVENT), null );
    Compartment obj = m.getCompartment(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), null );
  }

  public void test_Constraint_ancestor_add()
  {
    Constraint ct = new Constraint();
    Model m = new Model();
    m.addConstraint(ct);
    ct = null;
    ListOf lo = m.getListOfConstraints();
    Constraint obj = m.getConstraint(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), null );
  }

  public void test_Constraint_ancestor_create()
  {
    Model m = new Model();
    Constraint ct = m.createConstraint();
    ListOf lo = m.getListOfConstraints();
    assertEquals( ct.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( ct.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( ct.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( ct.getAncestorOfType(libsbml.SBML_EVENT), null );
    Constraint obj = m.getConstraint(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), null );
  }

  public void test_Delay_ancestor_add()
  {
    Delay d = new Delay();
    Event e = new Event();
    e.setDelay(d);
    d = null;
    Delay obj = e.getDelay();
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), e );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    e = null;
  }

  public void test_EventAssignment_ancestor_add()
  {
    Event e = new Event();
    EventAssignment ea = new EventAssignment();
    e.addEventAssignment(ea);
    ea = null;
    ListOf lo = e.getListOfEventAssignments();
    EventAssignment obj = e.getEventAssignment(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), e );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
  }

  public void test_EventAssignment_ancestor_create()
  {
    Event e = new Event();
    EventAssignment ea = e.createEventAssignment();
    ListOf lo = e.getListOfEventAssignments();
    assertEquals( ea.getAncestorOfType(libsbml.SBML_EVENT), e );
    assertEquals( ea.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( ea.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( ea.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
    EventAssignment obj = e.getEventAssignment(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), e );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
  }

  public void test_EventAssignment_ancestor_create_model()
  {
    Model m = new Model();
    Event e = m.createEvent();
    EventAssignment ea = m.createEventAssignment();
    ListOf lo = e.getListOfEventAssignments();
    assertEquals( ea.getAncestorOfType(libsbml.SBML_EVENT), e );
    assertEquals( ea.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( ea.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( ea.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( ea.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
    EventAssignment obj = e.getEventAssignment(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), e );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
  }

  public void test_Event_ancestor_add()
  {
    Event e = new Event();
    Model m = new Model();
    m.addEvent(e);
    e = null;
    ListOf lo = m.getListOfEvents();
    Event obj = m.getEvent(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
  }

  public void test_Event_ancestor_create()
  {
    Model m = new Model();
    Event e = m.createEvent();
    ListOf lo = m.getListOfEvents();
    assertEquals( e.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( e.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( e.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( e.getAncestorOfType(libsbml.SBML_PARAMETER), null );
    Event obj = m.getEvent(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), null );
  }

  public void test_FunctionDefinition_ancestor_add()
  {
    FunctionDefinition fd = new FunctionDefinition();
    Model m = new Model();
    m.addFunctionDefinition(fd);
    fd = null;
    ListOf lo = m.getListOfFunctionDefinitions();
    FunctionDefinition obj = m.getFunctionDefinition(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), null );
  }

  public void test_FunctionDefinition_ancestor_create()
  {
    Model m = new Model();
    FunctionDefinition fd = m.createFunctionDefinition();
    ListOf lo = m.getListOfFunctionDefinitions();
    assertEquals( fd.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( fd.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( fd.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( fd.getAncestorOfType(libsbml.SBML_EVENT), null );
    FunctionDefinition obj = m.getFunctionDefinition(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), null );
  }

  public void test_InitialAssignment_ancestor_add()
  {
    InitialAssignment ia = new InitialAssignment();
    Model m = new Model();
    m.addInitialAssignment(ia);
    ia = null;
    ListOf lo = m.getListOfInitialAssignments();
    InitialAssignment obj = m.getInitialAssignment(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), null );
  }

  public void test_InitialAssignment_ancestor_create()
  {
    Model m = new Model();
    InitialAssignment ia = m.createInitialAssignment();
    ListOf lo = m.getListOfInitialAssignments();
    assertEquals( ia.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( ia.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( ia.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( ia.getAncestorOfType(libsbml.SBML_EVENT), null );
    InitialAssignment obj = m.getInitialAssignment(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), null );
  }

  public void test_KineticLaw_Parameter_ancestor_add()
  {
    KineticLaw kl = new KineticLaw();
    Parameter p = new Parameter("jake");
    kl.addParameter(p);
    p = null;
    ListOfParameters lop = kl.getListOfParameters();
    Parameter obj = kl.getParameter(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_KINETIC_LAW), kl );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lop );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
    kl = null;
  }

  public void test_KineticLaw_Parameter_ancestor_create()
  {
    KineticLaw kl = new KineticLaw();
    Parameter p = kl.createParameter();
    assertTrue( kl.getNumParameters() == 1 );
    ListOfParameters lop = kl.getListOfParameters();
    assertEquals( p.getAncestorOfType(libsbml.SBML_KINETIC_LAW), kl );
    assertEquals( p.getAncestorOfType(libsbml.SBML_LIST_OF) , lop );
    assertEquals( p.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( p.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
    Parameter obj = kl.getParameter(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_KINETIC_LAW), kl );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lop );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
    kl = null;
  }

  public void test_KineticLaw_Parameter_ancestor_create_model()
  {
    Model m = new Model();
    Reaction r = m.createReaction();
    KineticLaw kl = m.createKineticLaw();
    Parameter p = m.createKineticLawParameter();
    assertTrue( kl.getNumParameters() == 1 );
    ListOfParameters lop = kl.getListOfParameters();
    assertEquals( p.getAncestorOfType(libsbml.SBML_KINETIC_LAW), kl );
    assertEquals( p.getAncestorOfType(libsbml.SBML_LIST_OF) , lop );
    assertEquals( p.getAncestorOfType(libsbml.SBML_REACTION), r );
    assertEquals( p.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( p.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( p.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
    Parameter obj = kl.getParameter(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_KINETIC_LAW), kl );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lop );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_REACTION), r );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
    kl = null;
  }

  public void test_KineticLaw_ancestor_add()
  {
    KineticLaw kl = new KineticLaw();
    Reaction r = new Reaction();
    r.setKineticLaw(kl);
    KineticLaw obj = r.getKineticLaw();
    assertEquals( obj.getAncestorOfType(libsbml.SBML_REACTION), r );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    r = null;
  }

  public void test_KineticLaw_ancestor_create()
  {
    Reaction r = new Reaction();
    KineticLaw kl = r.createKineticLaw();
    assertEquals( kl.getAncestorOfType(libsbml.SBML_REACTION), r );
    assertEquals( kl.getAncestorOfType(libsbml.SBML_DELAY), null );
    assertEquals( kl.getAncestorOfType(libsbml.SBML_MODEL), null );
    assertEquals( kl.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    KineticLaw obj = r.getKineticLaw();
    assertEquals( obj.getAncestorOfType(libsbml.SBML_REACTION), r );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DELAY), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    r = null;
  }

  public void test_KineticLaw_ancestor_create_model()
  {
    Model m = new Model();
    Reaction r = m.createReaction();
    KineticLaw kl = r.createKineticLaw();
    assertEquals( kl.getAncestorOfType(libsbml.SBML_REACTION), r );
    assertEquals( kl.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( kl.getAncestorOfType(libsbml.SBML_DELAY), null );
    assertEquals( kl.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    KineticLaw obj = r.getKineticLaw();
    assertEquals( obj.getAncestorOfType(libsbml.SBML_REACTION), r );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DELAY), null );
    r = null;
  }

  public void test_Model_ancestor_add()
  {
    SBMLDocument d = new SBMLDocument();
    Model m = new Model();
    d.setModel(m);
    assertEquals( d, d.getModel().getAncestorOfType(libsbml.SBML_DOCUMENT) );
    d = null;
  }

  public void test_Model_ancestor_create()
  {
    SBMLDocument d = new SBMLDocument();
    Model m = d.createModel();
    assertEquals( m.getAncestorOfType(libsbml.SBML_DOCUMENT), d );
    Model obj = d.getModel();
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), d );
    d = null;
  }

  public void test_Parameter_ancestor_add()
  {
    Parameter ia = new Parameter();
    Model m = new Model();
    m.addParameter(ia);
    ia = null;
    ListOf lo = m.getListOfParameters();
    Parameter obj = m.getParameter(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), null );
  }

  public void test_Parameter_ancestor_create()
  {
    Model m = new Model();
    Parameter p = m.createParameter();
    ListOf lo = m.getListOfParameters();
    assertEquals( p.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( p.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( p.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( p.getAncestorOfType(libsbml.SBML_EVENT), null );
    Parameter obj = m.getParameter(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), null );
  }

  public void test_RateRule_ancestor_create()
  {
    Model m = new Model();
    RateRule r = m.createRateRule();
    ListOf lo = m.getListOfRules();
    assertEquals( r.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( r.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( r.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( r.getAncestorOfType(libsbml.SBML_EVENT), null );
    Rule obj = m.getRule(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), null );
  }

  public void test_Reaction_ancestor_add()
  {
    Reaction ia = new Reaction();
    Model m = new Model();
    m.addReaction(ia);
    ia = null;
    ListOf lo = m.getListOfReactions();
    Reaction obj = m.getReaction(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), null );
  }

  public void test_Reaction_ancestor_create()
  {
    Model m = new Model();
    Reaction r = m.createReaction();
    ListOf lo = m.getListOfReactions();
    assertEquals( r.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( r.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( r.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( r.getAncestorOfType(libsbml.SBML_EVENT), null );
    Reaction obj = m.getReaction(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), null );
  }

  public void test_Rule_ancestor_add()
  {
    Rule ia = new RateRule("a");
    Model m = new Model();
    m.addRule(ia);
    ia = null;
    ListOf lo = m.getListOfRules();
    Rule obj = m.getRule(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), null );
  }

  public void test_SpeciesReference_Modifier_ancestor_add()
  {
    ModifierSpeciesReference sr = new ModifierSpeciesReference();
    Reaction r = new Reaction();
    r.addModifier(sr);
    sr = null;
    ListOf lo = r.getListOfModifiers();
    ModifierSpeciesReference obj = r.getModifier(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_REACTION), r );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
  }

  public void test_SpeciesReference_Modifier_ancestor_create()
  {
    Reaction r = new Reaction();
    ModifierSpeciesReference sr = r.createModifier();
    ListOf lo = r.getListOfModifiers();
    assertEquals( sr.getAncestorOfType(libsbml.SBML_REACTION), r );
    assertEquals( sr.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( sr.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( sr.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
    ModifierSpeciesReference obj = r.getModifier(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_REACTION), r );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
  }

  public void test_SpeciesReference_Modifier_ancestor_create_model()
  {
    Model m = new Model();
    Reaction r = m.createReaction();
    ModifierSpeciesReference sr = m.createModifier();
    ListOf lo = r.getListOfModifiers();
    assertEquals( sr.getAncestorOfType(libsbml.SBML_REACTION), r );
    assertEquals( sr.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( sr.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( sr.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( sr.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
    ModifierSpeciesReference obj = r.getModifier(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_REACTION), r );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
  }

  public void test_SpeciesReference_Product_ancestor_add()
  {
    SpeciesReference sr = new SpeciesReference();
    Reaction r = new Reaction();
    r.addProduct(sr);
    sr = null;
    ListOf lo = r.getListOfProducts();
    SpeciesReference obj = r.getProduct(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_REACTION), r );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
  }

  public void test_SpeciesReference_Product_ancestor_create()
  {
    Reaction r = new Reaction();
    SpeciesReference sr = r.createProduct();
    ListOf lo = r.getListOfProducts();
    assertEquals( sr.getAncestorOfType(libsbml.SBML_REACTION), r );
    assertEquals( sr.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( sr.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( sr.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
    SpeciesReference obj = r.getProduct(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_REACTION), r );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
  }

  public void test_SpeciesReference_Product_ancestor_create_model()
  {
    Model m = new Model();
    Reaction r = m.createReaction();
    SpeciesReference sr = m.createProduct();
    ListOf lo = r.getListOfProducts();
    assertEquals( sr.getAncestorOfType(libsbml.SBML_REACTION), r );
    assertEquals( sr.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( sr.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( sr.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( sr.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
    SpeciesReference obj = r.getProduct(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_REACTION), r );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
  }

  public void test_SpeciesReference_Reactant_ancestor_add()
  {
    SpeciesReference sr = new SpeciesReference();
    Reaction r = new Reaction();
    r.addReactant(sr);
    sr = null;
    ListOf lo = r.getListOfReactants();
    SpeciesReference obj = r.getReactant(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_REACTION), r );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
  }

  public void test_SpeciesReference_Reactant_ancestor_create()
  {
    Reaction r = new Reaction();
    SpeciesReference sr = r.createReactant();
    ListOf lo = r.getListOfReactants();
    assertEquals( sr.getAncestorOfType(libsbml.SBML_REACTION), r );
    assertEquals( sr.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( sr.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( sr.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
    SpeciesReference obj = r.getReactant(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_REACTION), r );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
  }

  public void test_SpeciesReference_Reactant_ancestor_create_model()
  {
    Model m = new Model();
    Reaction r = m.createReaction();
    SpeciesReference sr = m.createReactant();
    ListOf lo = r.getListOfReactants();
    assertEquals( sr.getAncestorOfType(libsbml.SBML_REACTION), r );
    assertEquals( sr.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( sr.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( sr.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( sr.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
    SpeciesReference obj = r.getReactant(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_REACTION), r );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
  }

  public void test_SpeciesType_ancestor_add()
  {
    SpeciesType ia = new SpeciesType();
    Model m = new Model();
    m.addSpeciesType(ia);
    ia = null;
    ListOf lo = m.getListOfSpeciesTypes();
    SpeciesType obj = m.getSpeciesType(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), null );
  }

  public void test_SpeciesType_ancestor_create()
  {
    Model m = new Model();
    SpeciesType st = m.createSpeciesType();
    ListOf lo = m.getListOfSpeciesTypes();
    assertEquals( st.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( st.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( st.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( st.getAncestorOfType(libsbml.SBML_EVENT), null );
    SpeciesType obj = m.getSpeciesType(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), null );
  }

  public void test_Species_ancestor_add()
  {
    Species ia = new Species();
    Model m = new Model();
    m.addSpecies(ia);
    ia = null;
    ListOf lo = m.getListOfSpecies();
    Species obj = m.getSpecies(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), null );
  }

  public void test_Species_ancestor_create()
  {
    Model m = new Model();
    Species s = m.createSpecies();
    ListOf lo = m.getListOfSpecies();
    assertEquals( s.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( s.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( s.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( s.getAncestorOfType(libsbml.SBML_EVENT), null );
    Species obj = m.getSpecies(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), null );
  }

  public void test_StoichiometryMath_ancestor_add()
  {
    StoichiometryMath m = new StoichiometryMath();
    SpeciesReference sr = new SpeciesReference();
    sr.setStoichiometryMath(m);
    m = null;
    StoichiometryMath obj = sr.getStoichiometryMath();
    assertEquals( obj.getAncestorOfType(libsbml.SBML_SPECIES_REFERENCE), sr );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    sr = null;
  }

  public void test_Trigger_ancestor_add()
  {
    Trigger d = new Trigger();
    Event e = new Event();
    e.setTrigger(d);
    d = null;
    Trigger obj = e.getTrigger();
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), e );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    e = null;
  }

  public void test_UnitDefinition_ancestor_add()
  {
    UnitDefinition ia = new UnitDefinition();
    Model m = new Model();
    m.addUnitDefinition(ia);
    ia = null;
    ListOf lo = m.getListOfUnitDefinitions();
    UnitDefinition obj = m.getUnitDefinition(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), null );
  }

  public void test_UnitDefinition_ancestor_create()
  {
    Model m = new Model();
    UnitDefinition ud = m.createUnitDefinition();
    ListOf lo = m.getListOfUnitDefinitions();
    assertEquals( ud.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( ud.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( ud.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( ud.getAncestorOfType(libsbml.SBML_EVENT), null );
    UnitDefinition obj = m.getUnitDefinition(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_EVENT), null );
  }

  public void test_Unit_ancestor_add()
  {
    UnitDefinition ud = new UnitDefinition();
    Unit u = new Unit();
    ud.addUnit(u);
    u = null;
    assertTrue( ud.getNumUnits() == 1 );
    ListOf lo = ud.getListOfUnits();
    Unit obj = ud.getUnit(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_UNIT_DEFINITION), ud );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
    ud = null;
  }

  public void test_Unit_ancestor_create()
  {
    UnitDefinition ud = new UnitDefinition();
    Unit u = ud.createUnit();
    assertTrue( ud.getNumUnits() == 1 );
    ListOf lo = ud.getListOfUnits();
    assertEquals( u.getAncestorOfType(libsbml.SBML_UNIT_DEFINITION), ud );
    assertEquals( u.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( u.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( u.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
    Unit obj = ud.getUnit(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_UNIT_DEFINITION), ud );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
    ud = null;
  }

  public void test_Unit_ancestor_create_model()
  {
    Model m = new Model();
    UnitDefinition ud = m.createUnitDefinition();
    Unit u = m.createUnit();
    assertTrue( ud.getNumUnits() == 1 );
    ListOf lo = ud.getListOfUnits();
    assertEquals( u.getAncestorOfType(libsbml.SBML_UNIT_DEFINITION), ud );
    assertEquals( u.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( u.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( u.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( u.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
    Unit obj = ud.getUnit(0);
    assertEquals( obj.getAncestorOfType(libsbml.SBML_UNIT_DEFINITION), ud );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_LIST_OF) , lo );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_DOCUMENT), null );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_MODEL), m );
    assertEquals( obj.getAncestorOfType(libsbml.SBML_COMPARTMENT), null );
    ud = null;
  }

  /**
   * Loads the SWIG-generated libSBML Java module when this class is
   * loaded, or reports a sensible diagnostic message about why it failed.
   */
  static
  {
    String varname;
    String shlibname;

    if (System.getProperty("mrj.version") != null)
    {
      varname = "DYLD_LIBRARY_PATH";    // We're on a Mac.
      shlibname = "libsbmlj.jnilib and/or libsbml.dylib";
    }
    else
    {
      varname = "LD_LIBRARY_PATH";      // We're not on a Mac.
      shlibname = "libsbmlj.so and/or libsbml.so";
    }

    try
    {
      System.loadLibrary("sbmlj");
      // For extra safety, check that the jar file is in the classpath.
      Class.forName("org.sbml.libsbml.libsbml");
    }
    catch (SecurityException e)
    {
      e.printStackTrace();
      System.err.println("Could not load the libSBML library files due to a"+
                         " security exception.\n");
      System.exit(1);
    }
    catch (UnsatisfiedLinkError e)
    {
      e.printStackTrace();
      System.err.println("Error: could not link with the libSBML library files."+
                         " It is likely\nyour " + varname +
                         " environment variable does not include the directories\n"+
                         "containing the " + shlibname + " library files.\n");
      System.exit(1);
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
      System.err.println("Error: unable to load the file libsbmlj.jar."+
                         " It is likely\nyour -classpath option and CLASSPATH" +
                         " environment variable\n"+
                         "do not include the path to libsbmlj.jar.\n");
      System.exit(1);
    }
  }
}

/**
 * 
 * You can add code anywhere in this file - except in the areas that are
 * written by the editor. You should not change the relative ordering of
 * the code.
 * 
 * You can remove this comment block or replace it with another.
 * 
 * @see		
 * @version	
 * @author	
 */

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.io.*;
import java.net.*;
import java.util.*;
import com.supercede.forms.*;

public class Form1 extends SuperCedeFrame implements Serializable
{

	void form1PreInit()
	{
		// You can add code anywhere in this method.
		// This method is called PRIOR to form initialization.
		// NOTE: The form has NOT been initialized yet. Do not modify the form itself in this method.
	}

	void form1PostInit()
	{
		// You can add code anywhere in this method.
		// This method is called AFTER form initialization.
	}

	public static void main(String args[])
	{
		// You can add code anywhere in this method.

		try
		{
			Form1 form = new Form1();
			form.setVisible(true);
		}
		catch(Throwable t)
		{
			System.out.println("Cannot construct the form: " + t);
			System.exit(1);
		}
	}

	public boolean form1WindowClosing(WindowEvent arg0)
	{
		// Put event handler code here. Return false for normal processing, true to override

		return false;
	}

	public boolean form1WindowClosed(WindowEvent arg0)
	{
		// Put event handler code here. Return false for normal processing, true to override

		return false;
	}

	// SuperCede Begin 2.0 Form Members
	// Do not remove the Begin and End markers.
	// The editor will rewrite the contents of this section each time the form is saved.

	private void SuperCedeConstructor() throws IOException, ClassNotFoundException, ClassCastException, SuperCedeInvalidStateException
	{
		// Construct the actual connectors to give to our base class.

		Vector connectors = new Vector(2);
		connectors.addElement(new Form1WindowClosingConnector0(this));
		connectors.addElement(new Form1WindowClosedConnector1(this));

		super.initializeThis(connectors);
	}

	public Form1() throws IOException, ClassNotFoundException, ClassCastException, SuperCedeInvalidStateException
	{
		super();

		form1PreInit();
		SuperCedeConstructor();
		form1PostInit();
	}

	public void SuperCedeWindowClosing(WindowEvent arg0)
	{
		if (form1WindowClosing(arg0) == false)
		{
			dispose();
		}
	}

	public void SuperCedeWindowClosed(WindowEvent arg0)
	{
		if (form1WindowClosed(arg0) == false)
		{
			System.exit(0);
		}
	}

	// SuperCede End 2.0 Form Members
}

// SuperCede Begin 2.0 Form Connectors
// Do not remove the Begin and End markers.
// The editor will rewrite the contents of this section each time the form is saved.
// Connections for Form1:
//	Form1WindowClosingConnector0: from Form1.windowClosing to Form1.SuperCedeWindowClosing
//	Form1WindowClosedConnector1: from Form1.windowClosed to Form1.SuperCedeWindowClosed

final class Form1WindowClosingConnector0 extends WindowAdapter implements SuperCedeConnector, Serializable
{
	private Form1 target;

	public Form1WindowClosingConnector0(Form1 target)
	{
		this.target = target;
	}

	public void windowClosing(WindowEvent arg0)
	{
		target.SuperCedeWindowClosing(arg0);
	}
}

final class Form1WindowClosedConnector1 extends WindowAdapter implements SuperCedeConnector, Serializable
{
	private Form1 target;

	public Form1WindowClosedConnector1(Form1 target)
	{
		this.target = target;
	}

	public void windowClosed(WindowEvent arg0)
	{
		target.SuperCedeWindowClosed(arg0);
	}
}

// The following line must be the last line in the file.
// SuperCede End 2.0 Form Connectors

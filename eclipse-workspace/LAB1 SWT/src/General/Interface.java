package General;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.*;
/**
 * Class which realize GUI 
 */
public class Interface {
    private Display display;
    private Shell shell;
    private Label labelMeter;
    private Label labelInch;
    private Button butMeter;
    private Button butInch;
    private Text txtfieldMeter;
    private Text txtfieldINCH;
    private Converterer conv;
    private Composite compMeter;
    private Composite compInch;
/**
 * This method start work with GUI
 */
    public void Launch() {
	Create_Elements();

    }
/**
* This method create elements of GUI and work with them 
*/
    private void Create_Elements() {
	Display display = new Display();
	Shell shell = new Shell(display);
	Composite compMeter = new Composite(shell, SWT.NONE);
	Composite compInch = new Composite(shell, SWT.NONE);
	Label labelMeter = new Label(compMeter, SWT.NONE);
	Label labelInch = new Label(compInch, SWT.NONE);
	Text txtfieldMeter = new Text(compMeter, SWT.BORDER);
	Text txtfieldINCH = new Text(compInch, SWT.BORDER);
	Button butMeter = new Button(compMeter, SWT.NONE);
	Button butInch = new Button(compInch, SWT.NONE);
	shell.setVisible(true);
	shell.setSize(300, 200);
	shell.setMinimumSize(300, 200);
	shell.setText("Converter");
	labelMeter.setLocation(10, 10);
	labelMeter.setText("Ìוענû");
	labelInch.setLocation(150, 10);
	labelInch.setText("Ä‏ילû");
	
	RowLayout rowLayoutmain = new RowLayout();
	rowLayoutmain.wrap = true;
	rowLayoutmain.pack = false;
	rowLayoutmain.justify = false;
	rowLayoutmain.type = SWT.HORIZONTAL;
	rowLayoutmain.marginLeft = 5;
	rowLayoutmain.marginTop = 5;
	rowLayoutmain.marginRight = 5;
	rowLayoutmain.marginBottom = 5;
	rowLayoutmain.spacing = 5;

	RowLayout rowLayout = new RowLayout();
	rowLayout.wrap = true;
	rowLayout.pack = false;
	rowLayout.justify = false;
	rowLayout.type = SWT.VERTICAL;
	rowLayout.marginLeft = 5;
	rowLayout.marginTop = 5;
	rowLayout.marginRight = 5;
	rowLayout.marginBottom = 5;
	rowLayout.spacing = 5;
	
	
	shell.setLayout(rowLayoutmain);
	compMeter.setLayout(rowLayout);
	compInch.setLayout(rowLayout);
	butMeter.setText("Ìוענû ג ה‏ילû");
	butMeter.setLocation(10, 10);
	butInch.setText("Ä‏ילû ג לוענû");
	txtfieldMeter.setEditable(true);
	txtfieldINCH.setEditable(true);
	butMeter.addSelectionListener(new SelectionAdapter(){
	    @Override
	    public void widgetSelected(SelectionEvent e) {
		try {
		    Float.parseFloat(txtfieldMeter.getText());
		}
		catch (NumberFormatException ex) {
		    txtfieldMeter.clearSelection();
		    return;
		}
		Converterer tmp=new Converterer(Float.parseFloat(txtfieldMeter.getText()),(float) 0);
		txtfieldINCH.setText(Float.toString(tmp.convertMeterstoInches()));
	    }	
	});
	
	butInch.addSelectionListener(new SelectionAdapter() { 
	    @Override
	    public void widgetSelected(SelectionEvent e) {
		try {
		   Float.parseFloat(txtfieldINCH.getText());
		}   	        
		catch (NumberFormatException ex) {
		    txtfieldINCH.clearSelection();
		    return;
		}
		Converterer tmp=new Converterer((float) 0,Float.parseFloat(txtfieldINCH.getText()));
		txtfieldMeter.setText(Float.toString(tmp.convertInchestoMeters()));
	    }    
	});
	
	shell.open();
	while (!shell.isDisposed()) {
	    if (!display.readAndDispatch())
		display.sleep();
	}
	display.dispose();
   }
 }
    
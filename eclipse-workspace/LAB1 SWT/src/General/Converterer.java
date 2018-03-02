package General;
/**
 * This class included logic of my converter
 */
public class Converterer {
    	private Float meter;
	private Float inch;

	public Converterer(Float meter, Float inch) {
	     super();
	     this.meter = meter;
	     this.inch = inch;
	}
	    
	/**
	 * This method convert Inches to Meters 
	 */
	public Float convertInchestoMeters() {
	     return meter= (float) (inch*0.0254);
	 }
	    
	 /**
	  * This method convert Meters to Inches 
	  */
	public Float convertMeterstoInches() {
	     return inch= (float) (meter/0.0254);
	}
}




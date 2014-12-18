package edu.ew.model;

/**
 * Represents a set of energies ( earth, air, fire, water and pure)
 * Holds the number of each type of energy.
 * 
 * @author Selcuk Gulcan
 * 
 */
public class EnergySet {

	private int pure;
	private int air;
	private int earth;
	private int fire;
	private int water;
	private int trivial;
	
	public EnergySet() {
		
		clear();
	}
	
	public EnergySet( Energy type, int no) {
		
		clear();
		setEnergy( type, no);
	}
	
	public EnergySet( int noOfAirEnergy, int noOfEarthEnergy, int noOfFireEnergy, int noOfWaterEnergy) {
		
		setTrivial( 0);
		setPure( 0);
		setAir( noOfAirEnergy);
		setEarth( noOfEarthEnergy);
		setFire( noOfFireEnergy);
		setWater( noOfWaterEnergy);
	}
	
	public EnergySet( int noOfAirEnergy, int noOfEarthEnergy, int noOfFireEnergy, int noOfWaterEnergy, int noOfPureEnergy) {
		
		setTrivial( 0);
		setPure( noOfPureEnergy);
		setAir( noOfAirEnergy);
		setEarth( noOfEarthEnergy);
		setFire( noOfFireEnergy);
		setWater( noOfWaterEnergy);
	}
	
	public EnergySet( int noOfAirEnergy, int noOfEarthEnergy, int noOfFireEnergy, int noOfWaterEnergy, int noOfPureEnergy, 
					  int noOfTrivialEnergy) {
		
		setPure( noOfPureEnergy);
		setAir( noOfAirEnergy);
		setEarth( noOfEarthEnergy);
		setFire( noOfFireEnergy);
		setWater( noOfWaterEnergy);
		setTrivial( noOfTrivialEnergy);
	}
	
	public EnergySet( EnergySet other) {
		
		setPure( other.getPure());
		setAir( other.getAir());
		setEarth( other.getEarth());
		setFire( other.getFire());
		setWater( other.getWater());
		setTrivial( other.getTrivial());
	}
	
	public int getPure() {
		return pure;
	}

	public void setPure(int pure) {
		this.pure = pure;
	}

	public int getAir() {
		return air;
	}

	public void setAir(int air) {
		this.air = air;
	}

	public int getEarth() {
		return earth;
	}

	public void setEarth(int earth) {
		this.earth = earth;
	}

	public int getFire() {
		return fire;
	}

	public void setFire(int fire) {
		this.fire = fire;
	}
	
	public int getTrivial() {
		return trivial;
	}
	
	public void setTrivial( int trivial) {
		this.trivial = trivial;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}

	public void setEnergy( Energy type, int no) {
		
		switch( type) {
		
		case AIR:
			setAir( no);
			break;
			
		case EARTH:
			setEarth( no);
			break;
			
		case FIRE:
			setFire( no);
			break;
			
		case PURE:
			setPure( no);
			break;
			
		case TRIVIAL:
			setTrivial( no);
			break;
			
		case WATER:
			setWater( no);
			break;
			
		default:
			break;		
		}
	}
	
	public void clear() {
		
		setPure( 0);
		setTrivial( 0);
		setAir( 0);
		setEarth( 0);
		setFire( 0);
		setWater( 0);
	}
	
	EnergySet intersect( EnergySet other) {
		
		return new EnergySet( 	Math.abs( getAir() - other.getAir()), 
								Math.abs( getEarth() - other.getEarth()),
								Math.abs( getFire() - other.getFire()), 
								Math.abs( getWater() - other.getWater()), 
								Math.abs( getPure() - other.getPure()),
								Math.abs( getTrivial() - other.getTrivial())
							);
	}
	
	boolean hasSubsetOf( EnergySet other) {
		
		if( getAir() < other.getAir())
			return false;
		
		if( getEarth() < other.getEarth())
			return false;
		
		if( getFire() < other.getFire())
			return false;
		
		if( getWater() < other.getWater())
			return false;
		
		if( getPure() < other.getPure())
			return false;
		
		if( getTrivial() < other.getTrivial())
			return false;
		
		return true;
	}
	
	boolean canPay( EnergySet other) {
		
		//TODO: complete method
		return false;
	}
	
	boolean canPayWithConversion( EnergySet other) {
		
		//TODO: complete method
		return false;
	}
	
	int getConvertCost( EnergySet other) {
		
		//TODO: complete method
		return 0;
	}
	
	int convert( EnergySet other) {
		
		//TODO: complete method
		return 0;
	}
	
	EnergySet copy() {
		
		EnergySet copied = new EnergySet( this);
		return copied;
	}
	
	@Override
	public String toString() {
		
		String stringToReturn = "";
		
		stringToReturn = "[" + air + ", " + earth + ", " + fire + ", " + water + ", " + pure
				+ ", " + trivial + "]";
		
		return stringToReturn;
	}
}

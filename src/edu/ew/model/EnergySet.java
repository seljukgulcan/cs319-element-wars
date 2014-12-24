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
	
	
	
	//TRIVIAL METHODS
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
		
		int remainder = 0;
		if( air < other.getAir())
			return false;
		remainder += air - other.getAir();
		
		if( earth < other.getEarth())
			return false;
		remainder += earth - other.getEarth();
		
		if( fire < other.getFire())
			return false;
		remainder += fire - other.getFire();
		
		if( water < other.getWater())
			return false;
		remainder += water - other.getWater();
		
		if( pure < other.getPure())
			return false;
		remainder += pure - other.getPure();
		
		if( remainder < other.getTrivial())
			return false;
		
		return true;
	}
	
	public void consume( EnergySet other) {
		
		//Assuming this energyset can pay other.
		air -= other.getAir();
		earth -= other.getEarth();
		fire -= other.getFire();
		water -= other.getWater();
		pure -= other.getPure();
		
		int needToPay = other.getTrivial();
		if( trivial >= needToPay) {
			
			trivial -= needToPay;
			return;
		}
		else {
			
			trivial = 0;
			needToPay -= trivial;
		}
		
		//pay with air
		if( air >= needToPay) {
			
			air -= needToPay;
			return;
		}
		else {
			
			air = 0;
			needToPay -= air;
		}
		
		//pay with earth
		if( earth >= needToPay) {
			
			earth -= needToPay;
			return;
		}
		else {
			
			earth = 0;
			needToPay -= earth;
		}
		
		//pay with fire
		if( fire >= needToPay) {
			
			fire -= needToPay;
			return;
		}
		else {
			
			fire = 0;
			needToPay -= fire;
		}
		
		//pay with water
		if( water >= needToPay) {
			
			water -= needToPay;
			return;
		}
		else {
			
			water = 0;
			needToPay -= water;
		}
		
		//pay with pure
		pure -= needToPay;
	}
	
	public boolean canPayWithConversion( EnergySet other) {
		
		int needToConvert = 0;
		int extra = 0;
		
		if( other.getPure() >= getPure())
			return false;
		
		if( getPure() == 0)
			return false;
		
		extra = getPure() - other.getPure() - 1;
		
		if( other.getAir() > getAir())
			needToConvert += other.getAir() - getAir();
		else
			extra += getAir() - other.getAir();
		
		if( other.getEarth() > getEarth())
			needToConvert += other.getEarth() - getEarth();
		else
			extra += getEarth() - other.getEarth();
		
		if( other.getFire() > getFire())
			needToConvert += other.getFire() - getFire();
		else
			extra += getFire() - other.getFire();
		
		if( other.getWater() > getWater())
			needToConvert += other.getWater() - getWater();
		else
			extra += getWater() - other.getWater();
		
		if( needToConvert > 1)
			return false;
		
		if( extra < other.getTrivial())
			return false;
		
		return true;
	}
	
	public int getConvertCost( EnergySet other) {
		
		//TODO: complete method
		return 0;
	}
	
	public Energy convert( EnergySet other) {
		//Assumption energyset can be converted with 1 pure energy
		
		if( getAir() < other.getAir()) {
			
			pure--;
			air++;
			return Energy.AIR;
		}
		
		else if( getEarth() < other.getEarth()) {
			
			pure--;
			earth++;
			return Energy.EARTH;
		}
		else if( getFire() < other.getFire()) {
			
			pure--;
			fire++;
			return Energy.FIRE;
		}
		
		else if( getWater() < other.getWater()) {
			
			pure--;
			water++;
			return Energy.WATER;
		}
		
		return Energy.PURE;
	}
	
	public EnergySet copy() {
		
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

	public int getEnergy(Energy converted) {
		
		switch( converted) {
		case AIR:
			return getAir();
		case EARTH:
			return getEarth();
		case FIRE:
			return getFire();
		case PURE:
			return getPure();
		case TRIVIAL:
			return getTrivial();
		case WATER:
			return getWater();
		}
		
		return -1;
	}
}

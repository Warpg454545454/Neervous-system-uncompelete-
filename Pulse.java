package com.nervous_system.object;

public class Pulse {
   public double front_position;
   public double behind_position;
   public double pulse_length;
   public boolean direction;
   public double value;
   public static final double speed=1;
   public Pulse(double front,double behind,double value) {
	   this.front_position=front;
	   this.behind_position=behind;
	   this.pulse_length=Math.abs(this.behind_position-this.front_position);
	   this.value=value;
	   if(this.behind_position<=this.front_position) {
		   this.direction=true;
	   }else {
		   this.direction=false;
	   }
	   
   };
   public void move() {
	   if(this.direction) {
		   this.front_position+=Pulse.speed;
		   this.behind_position+=Pulse.speed;
	   }else {
		   this.front_position-=Pulse.speed;
	       this.behind_position-=Pulse.speed;
		   
	   }
	   
   };
   public boolean if_position_in_pulse(double a) {
	   if((Math.abs(a-this.front_position)+Math.abs(a-this.behind_position))<=this.pulse_length) {
			return true;
		}else {
			return false;
		}
   };

}

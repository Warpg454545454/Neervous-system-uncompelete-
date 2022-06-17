package com.nervous_system.object;
import com.nervous_system.object.Neuron;
import com.nervous_system.object.Pulse;
import com.nervous_system.object.Container;
import java.util.ArrayList;
public class Fibre {
	public double life=500;
	public static final double add_life=4;
	public static final double cut_life=1;
	public double side1_position;
	public double side2_position;
	public double Fibre_length;
	public boolean direction;
	public String name;
	public Neuron side1_neuron;
	public Neuron side2_neuron;
	public String side1_name;
	public String side2_name;
	public boolean if_activation_side2;
	public ArrayList<Pulse> pulse_list=new ArrayList<Pulse>();
	public Fibre(double side1,double side2) {
		this.side1_position=side1;
		this.side2_position=side2;
		this.Fibre_length=Math.abs(this.side2_position-this.side2_position);
		if(this.side1_position<=this.side2_position) {
			this.direction=true;
		}else {
			this.direction=false;
		}
		
	};
	public boolean if_position_on_fibre(double a) {
		if((Math.abs(a-this.side1_position)+Math.abs(a-this.side2_position))<=this.Fibre_length) {
			return true;
		}else {
			return false;
		}
		
	};
	public boolean if_pulse_on_fibre(Pulse a) {
		if(this.if_position_on_fibre(a.front_position)&&this.if_position_on_fibre(a.behind_position)) {
			return true;
		}else {
			return false;
		}
		
		
	};
	public boolean if_side2_in_the_pulse(Pulse a) {
		if(a.if_position_in_pulse(this.side2_position)) {
			return true;
		}else {
			return false;
		}
	};
	public void check_and_activation() {
		for(Pulse a:this.pulse_list) {
			if(this.if_side2_in_the_pulse(a)) {
				this.side2_neuron.receive_excitement=this.side2_neuron.receive_excitement+a.value;
			}else {}
		}
	}
	public static void delete_fibre(Fibre a) {
		for(Pulse b:a.pulse_list) {
			a.pulse_list.remove(b);
			b=null;
		}
		a.side1_neuron.connect_list.remove(a);
		a.side2_neuron.connected_list.remove(a);
		Container.Fibre_list.remove(a);
		a=null;
	};
	public void Creat_Pulse_on_side(boolean i,double value) {
		//Here,i means side1 or side2,if true ,is side1,if false ,is side_2
		if(this.direction) {
			if(i) {
				Pulse a=new Pulse(this.side1_position+1,this.side2_position,value);
				this.pulse_list.add(a);
			}else {
				Pulse b=new Pulse(this.side2_position-1,this.side2_position,value);
				this.pulse_list.add(b);
			}
		}else {
			if(i) {
				Pulse c=new Pulse(this.side1_position-1,this.side1_position,value);
				this.pulse_list.add(c);
			}else {
				Pulse d=new Pulse(this.side2_position+1,this.side2_position,value);
				this.pulse_list.add(d);
			}
		}
		
	};
	public void life_handler() {
		double n=0;
		for(Pulse i:this.pulse_list) {
			if(this.if_side2_in_the_pulse(i)) {
				n=n+Fibre.add_life;
			}else {}
		}
		if(n<=0) {
			this.life+=n;
		}else {
			this.life-=Fibre.cut_life;
		}
		
	};
	public boolean If_live() {
		if(this.life<=0) {
			return false;
		}else {
			return true;
		}
	}
	public static void Fibre_killer(Fibre a) {
		if(a.If_live()) {
			
		}else {
			Fibre.delete_fibre(a);
		}
		
	}
	public void run() {
		for(Pulse a:this.pulse_list) {
			a.move();
		}
		this.life_handler();
		this.check_and_activation();
		
	};

	

}

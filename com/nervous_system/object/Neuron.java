package com.nervous_system.object;
import java.util.ArrayList;

import com.nervous_system.object.Block;
import com.nervous_system.object.Fibre;
import com.nervous_system.object.Container;
public class Neuron extends Cell {
	public double[] time_and_space_sum=new double[10];
	public double[] angle=new double[2];
	public boolean if_excitement;
	public static final double  act_number=1;
	
	public boolean if_lit_up=false;
	public static final double threshold=15;
	public static final double touch_diatance=Block.touch_distance;
	ArrayList<Fibre> connect_list=new ArrayList<Fibre>();
	ArrayList<Fibre> connected_list=new ArrayList<Fibre>();
	public Neuron(double x,double y,Block a,boolean if_excitement,double[] angle) {
		super(x, y, a);
		this.angle[0]=angle[0];
		this.angle[1]=angle[1];
		this.if_excitement=if_excitement;
		for(int i=0;i<10;i=i+1) {
			this.time_and_space_sum[i]=0;
		};
		
	};
	public static void delete_neuron(Neuron a) {
		for(Fibre i:a.connect_list) {
			Fibre.delete_fibre(i);
		}
		for(Fibre j:a.connected_list) {
			Fibre.delete_fibre(j);
		}
		Cell.remove_cell_on_list(a);
		Container.Neuron_list.remove(a);
		a=null;
		
	};
	public void time_and_space_sum_handler() {
		this.time_and_space_sum[9]=this.receive_excitement;
		for(int x=0;x<10;x=x+1) {
			if(x==9) {
				this.time_and_space_sum[x]=0;
			}else {
				this.time_and_space_sum[x]=this.time_and_space_sum[x+1];
			}
		}
		
	};
	public boolean judge_If_lit_up() {
		double a=0;
		for(int x=0;x<5;x=x+1) {
			a=a+this.time_and_space_sum[x];
		}
		if(Neuron.threshold<=a) {
			return true;
		}else {
			return false;
		}
	}
	public void lit_up() {
		double j=Neuron.act_number;
		if(this.if_excitement) {
			
		}else {
			j=-Neuron.act_number;
		}
		for(Fibre a:this.connect_list) {
			
			a.Creat_Pulse_on_side(true, j);
			
		}
	};
	public void run() {
		this.time_and_space_sum_handler();
		if(this.if_lit_up) {
			this.lit_up();
		}
	}
	
	

}

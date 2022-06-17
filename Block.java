package com.nervous_system.object;
import com.nervous_system.object.Neuron;
import com.nervous_system.object.Cell;
import com.nervous_system.object.Container;
import java.util.ArrayList;
public class Block {
	public double x;
	public double y;
	public double left_line;
	public double right_line;
	public double up_line;
	public double down_line;
	public String name;
	public ArrayList<Neuron> neuron_list=new ArrayList<Neuron>();
	public ArrayList<Cell> cell_list=new ArrayList<Cell>();
	public Block[] suround_block_list=new Block[8];
	public static final double touch_distance=4;
//x, y mean a block"middle" x and y position
	public Block(double x,double y) {
		this.x=x;
		this.y=y;
		this.left_line=x-Block.touch_distance;
		this.right_line=x+Block.touch_distance;
		this.up_line=y+Block.touch_distance;
		this.down_line=y-Block.touch_distance;		
		this.name="Block"+"_"+String.valueOf(this.x)+"_"+String.valueOf(this.y);
		
	};
	public static double[] toBlock_Middle(double x,double y) {
		double x1=Math.floor(x/Block.touch_distance)*(Block.touch_distance)+(Block.touch_distance/2);
		double y1=Math.floor(y/Block.touch_distance)*(Block.touch_distance)+(Block.touch_distance/2);
		double[] a=new double[2];
		a[0]=x1;
		a[1]=y1;
		return a;
	}
	public boolean if_position_in_block(double x,double y) {
		if(((this.left_line<=x)&&(x<this.right_line))&&((this.down_line<=y)&&(y<this.up_line))){
			return true;
		}else {
			return false;
		}
	};
	public static Block find_block(double x,double y) {
		Block[] a=new Block[1];
		for(Block i:Container.Block_list) {
			if(i.if_position_in_block(x, y)) {
				a[0]=i;
			}else {}
			
		}
		return a[0];
	};
	public static boolean if_position_in_any_block(double x,double y) {
		int n=0;
		for(Block i:Container.Block_list) {
			if(i.if_position_in_block(x, y)) {
				n=n+1;
			}else {}
		}
		if(0<n){
			return true;
		}else {
			return false;
		}
		
	};
	public void load_surrounds() {
		double x1=this.x-Block.touch_distance;
		double x2=this.x;
		double x3=this.x+Block.touch_distance;
		double x4=this.x-Block.touch_distance;	
		double x5=this.x+Block.touch_distance;
		double x6=this.x-Block.touch_distance;
		double x7=this.x;
		double x8=this.x+Block.touch_distance;
		double y1=this.y+Block.touch_distance;
		double y2=this.y+Block.touch_distance;
		double y3=this.y+Block.touch_distance;	
		double y4=this.y;
		double y5=this.y;
		double y6=this.y-Block.touch_distance;
		double y7=this.y-Block.touch_distance;
		double y8=this.y-Block.touch_distance;
		boolean p1=Block.if_position_in_any_block(x1, y1);
		boolean p2=Block.if_position_in_any_block(x2, y2);
		boolean p3=Block.if_position_in_any_block(x3, y3);
		boolean p4=Block.if_position_in_any_block(x4, y4);
		boolean p5=Block.if_position_in_any_block(x5, y5);
		boolean p6=Block.if_position_in_any_block(x6, y6);
		boolean p7=Block.if_position_in_any_block(x7, y7);
		boolean p8=Block.if_position_in_any_block(x8, y8);
		if(p1){
			this.suround_block_list[0]=Block.find_block(x1, y1);
		}else {
			Block a=new Block(Block.toBlock_Middle(x1, y1)[0],Block.toBlock_Middle(x1, y1)[1]);
			Container.Block_list.add(a);
			this.suround_block_list[0]=a;
		};
		if(p2){
			this.suround_block_list[0]=Block.find_block(x2, y2);
		}else {
			Block b=new Block(Block.toBlock_Middle(x2, y2)[0],Block.toBlock_Middle(x2, y2)[1]);
			Container.Block_list.add(b);
			this.suround_block_list[1]=b;
		};
		if(p3){
			this.suround_block_list[0]=Block.find_block(x3, y3);
		}else {
			Block c=new Block(Block.toBlock_Middle(x3, y3)[0],Block.toBlock_Middle(x3, y3)[1]);
			Container.Block_list.add(c);
			this.suround_block_list[2]=c;
		};
		if(p4){
			this.suround_block_list[0]=Block.find_block(x4, y4);
		}else {
			Block d=new Block(Block.toBlock_Middle(x4, y4)[0],Block.toBlock_Middle(x4, y4)[1]);
			Container.Block_list.add(d);
			this.suround_block_list[3]=d;
		};
		if(p5){
			this.suround_block_list[0]=Block.find_block(x5, y5);
		}else {
			Block e=new Block(Block.toBlock_Middle(x5, y5)[0],Block.toBlock_Middle(x5, y5)[1]);
			Container.Block_list.add(e);
			this.suround_block_list[4]=e;
		};
		if(p6){
			this.suround_block_list[0]=Block.find_block(x6, y6);
		}else {
			Block f=new Block(Block.toBlock_Middle(x6, y6)[0],Block.toBlock_Middle(x6, y6)[1]);
			Container.Block_list.add(f);
			this.suround_block_list[5]=f;
		};
		if(p7){
			this.suround_block_list[0]=Block.find_block(x7, y7);
		}else {
			Block g=new Block(Block.toBlock_Middle(x7, y7)[0],Block.toBlock_Middle(x7, y7)[1]);
			Container.Block_list.add(g);
			this.suround_block_list[6]=g;
		};
		if(p8){
			this.suround_block_list[0]=Block.find_block(x8, y8);
		}else {
			Block h=new Block(Block.toBlock_Middle(x8, y8)[0],Block.toBlock_Middle(x8, y8)[1]);
			Container.Block_list.add(h);
			this.suround_block_list[7]=h;
		};
	};
	public static Block Create_block(double x,double y) {
		Block a=new Block(x,y);
		Container.Block_list.add(a);
		return a;
		
	};
	public static void void_Create_block(double x,double y) {
		Block a=new Block(x,y);
		Container.Block_list.add(a);
	};
	

}

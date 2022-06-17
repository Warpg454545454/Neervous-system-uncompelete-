package com.nervous_system.object;
import com.nervous_system.object.Block;
import com.nervous_system.object.Container;
public class Cell {
	public double receive_excitement=0;
	public double x;
	public double y;
	public String name;
	public Block belong_block;
	public String belong_block_name;
	public Cell(double x,double y,Block a) {
		this.x=x;
		this.y=y;
		this.belong_block=a;
		this.name=a.name+"Cell"+"_"	+String.valueOf(this.x)+"_"+String.valueOf(this.y);
	};
//create a cell and relate to the block	
	public static Cell Create_cell(double x,double y) {
		boolean p=false;
		Block[] b=new Block[1];
		for(Block a:Container.Block_list) {
			if(a.if_position_in_block(x, y)) {
				p=true;
				b[0]=a;
			}else {}
		}
		if(p) {
			
			Cell c=new Cell(x,y,b[0]);		
			b[0].cell_list.add(c);
			Container.Cell_list.add(c);
			b[0].load_surrounds();
			return c;
		}else {
			Block d=new Block(Block.toBlock_Middle(x, y)[0],Block.toBlock_Middle(x, y)[1]);
			Container.Block_list.add(d);
			Cell e=new Cell(x,y,d);
			d.cell_list.add(e);
			d.load_surrounds();
			Container.Cell_list.add(e);
			return e;
		}
		
	};
	public static void Void_Create_cell(double x,double y) {
		boolean p=false;
		Block[] b=new Block[1];
		for(Block a:Container.Block_list) {
			if(a.if_position_in_block(x, y)) {
				p=true;
				b[0]=a;
			}else {}
		}
		if(p) {
			
			Cell c=new Cell(x,y,b[0]);		
			b[0].cell_list.add(c);
			Container.Cell_list.add(c);
			b[0].load_surrounds();
			
		}else {
			Block d=new Block(Block.toBlock_Middle(x, y)[0],Block.toBlock_Middle(x, y)[1]);
			Container.Block_list.add(d);
			Cell e=new Cell(x,y,d);
			d.cell_list.add(e);
			d.load_surrounds();
			Container.Cell_list.add(e);
			
	}
	

   }
	public void excitement_handler() {
		this.receive_excitement=0;
	};
	public static void remove_cell_on_list(Cell a) {
		a.belong_block.cell_list.remove(a);
		Container.Cell_list.remove(a);
		
	};
	public static void Delete_Cell(Cell a) {
		a.belong_block.cell_list.remove(a);
		Container.Cell_list.remove(a);
		a=null;
	};
}
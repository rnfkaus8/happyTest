package com.happy.board.usebean;

public class InputPhoto {
	
	private int depth;
	
	
	
	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getPhoto(){
		String result = "";
		String pic = "<img alt=\"답글\" src=\"./img/reply.png\">";
		String blank = "&nbsp;&nbsp;&nbsp;&nbsp;";
		if(depth>0){
			for(int i = 0; i < depth; i++){
				result += blank;
			}
			result += pic;
		}
		return result;
	} // photo
}

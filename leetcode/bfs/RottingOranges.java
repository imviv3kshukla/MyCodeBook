

import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


class Cell {
	int x;
    int y;
	Cell(int x, int y) {this.x = x; this.y = y;}
}


public class RottingOranges {

    public int orangesRotting(int [][]grid) {
		int dir[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};
		Queue<Cell> queue = new LinkedList<>();
		for(int i=0;i<grid.length;i++) {
			for(int j=0; j< grid[0].length;j++) {
				if(grid[i][j] == 2) queue.add(new Cell(i, j));
			}
		}
		
		int answer = -1;

		while(!queue.isEmpty()) {
			int size = queue.size();
			answer++;
			while(size-- > 0) {
				Cell curr = queue.poll();
				for(int i=0;i<4;i++) {
					int x = curr.x + dir[i][0];
					int y = curr.y + dir[i][1];
					if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
						queue.add(new Cell(x,y));
						grid[x][y] = 2;
					}
				}
			}
		}
		return answer;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
    }
}
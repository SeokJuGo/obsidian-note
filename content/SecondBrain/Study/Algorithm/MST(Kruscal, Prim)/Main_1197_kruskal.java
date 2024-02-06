

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1197_kruskal {

	static int V,E;
	static long min;  
	static class Edge implements Comparable<Edge>{
		int s;
		int e;
		int w;
		public Edge(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	static PriorityQueue<Edge> points;
	// kruskal
	static int[] p;
	static int[] r;
	static int T;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T =Integer.parseInt(br.readLine());
		for (int x = 1; x < T+1; x++) {
			
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		points=new PriorityQueue<>();
		for (int i = 0; i < E; i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			points.offer(new Edge(s, e, w));
		}
		p=new int[V+1];
		r=new int[V+1];
		makeSet();
		int cnt=0;  // V-1ȸ �ݺ�
		min=0;
		while(cnt!=V-1) {
			Edge edge=points.poll();
			if(union(edge.s,edge.e)) {
				cnt++;
				min+=edge.w;
			}
		}
		System.out.print("#"+x+" ");
		System.out.println(min);
	}
	}
	static boolean union(int x, int y) {
		x=find(x);
		y=find(y);
		if(x==y) return false; // Cycle�߻� false
		if(r[x]<r[y]) {
			r[y]+=r[x];
			p[x]=y;
		}else {
			r[x]+=r[y];
			p[y]=x;
		}
		return true;
	}

	static int find(int x) {
		if(x==p[x]) return p[x];
		else return p[x]=find(p[x]);
	}

	static void makeSet() {
		for (int i = 0; i < V+1; i++) {
			p[i]=i;
		}
		for (int i = 0; i < V+1; i++) {
			r[i]=1;
		}
	}

}

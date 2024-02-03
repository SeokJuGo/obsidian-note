## 목차

[크루스칼 알고리즘](#kruscal)

[프림 알고리즘](#prim)

# Kruscal

## 1) 그래프표현

1) 정점중심

- 인접행렬
- 인접리스트

2) 간선중심

- 간선리스트

kruscal, prim 정점중심 -간선리스트 

- **간**선이 **적**으면 **크**루스칼 알고리즘을 사용

## 2) 순서

```java
1) 모든 간선을 가중치에 따라 오름차순으로 정렬 - PriorityQueue
2) 가중치가 낮은 간선부터 선택하면서 트리를 증가시킴
3) n-1개의 간선이 선택 될때까지 2. 반복
```

```java
//		1) 오름차순
		Arrays.sort(edgeList);
	
		
		int result = 0; // MST 비용
		int count = 0;  // 연결된 간선 개수
		
//		2) 가중치 낮은 간선 선택
		for (Edge edge : edgeList) {
			if(union(edge.from,edge.to)) {
				result += edge.weight;
				
//				3) n-1개의 간선이 되면
				if(++count==V-1) break;
			}
		}
		System.out.println(result);
	}
```



# Prim

- **간**선이 **많**으면 **프**림알고리즘을 사용 => V(V-1)/2 

## 1) 순서

```java
1) 임의 정점 하나 선택
2) 선택한 정점과 인접하는 정점 중 최소 비용 정점 선택
3) 모든 정점 선택까지 1. 2. 반복
```

```java
		min = 0L;
		boolean[] visited = new boolean[V+1];   

		points.offer(new Edge(1,0)); 
		int cnt=0;
		while(!points.isEmpty()) {
            // 1) 임의 접점 시작
			Edge edge=points.poll();
			if(visited[edge.v]) continue;
			min+=edge.w;
			visited[edge.v]=true;
			if(++cnt==V) return min; // V-1 모두 찾으면
			for (int i = 0; i < adj[edge.v].size(); i++) {
				Edge next=adj[edge.v].get(i);
				if(visited[next.v]) continue;
				points.offer(next);
```


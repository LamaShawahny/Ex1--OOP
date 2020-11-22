package ex1.tests;

import org.junit.jupiter.api.Test;
import ex1.src.WGraph_Algo;
import ex1.src.WGraph_DS;
import ex1.src.node_info;
import ex1.src.weighted_graph;
import ex1.src.weighted_graph_algorithms;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;
import java.util.List;


class WGraph_AlgoTestL {
    
	
	
	
	
	@Test ///Test for empty graph
	void EmptyG() {
		weighted_graph emptyGraph =new WGraph_DS();
		weighted_graph_algorithms graph = new  WGraph_Algo();
        graph.init(emptyGraph);
        
        
        assertTrue(graph.isConnected());
        
          
    }
	
	@Test
	
	
     // Simple single node graph
    
      void Single() {
		weighted_graph  g = new WGraph_DS();
		weighted_graph_algorithms  graph = new WGraph_Algo();
		g.addNode(5);
        graph.init(g);
	        assertTrue(graph.isConnected());
    }
	
	
	
	
	

	@Test
	 
     // graph with two nodes and no edges - not connected
     
        void TNGraph() {
		weighted_graph g = new WGraph_DS(); 
		weighted_graph_algorithms graph = new  WGraph_Algo();
		g.addNode(2);
		g.addNode(3);
        graph.init(g);
  
        assertFalse(graph.isConnected());

	}
	
	
	
	
	@Test
	 
     // graph with two nodes and a single edge - connected
     
    void tWowithEdge() {

        weighted_graph g =new WGraph_DS();
		weighted_graph_algorithms graph = new  WGraph_Algo();
		g.addNode(1);
		g.addNode(2);
		g.connect(2, 1,18);
        graph.init(g);
        assertTrue(graph.isConnected());
    }
	@Test
	void triangleisConnected() {
    weighted_graph g =new WGraph_DS();
	weighted_graph_algorithms graph = new  WGraph_Algo();
	g.addNode(1);
	g.addNode(2);
	g.addNode(3);
	g.connect(2, 1,18);
	g.connect(2, 3,18);
	g.connect(3, 1,18);
    graph.init(g);
    assertTrue(graph.isConnected());
}
	@Test
	void trianglenotConnected() {
	    weighted_graph g =new WGraph_DS();
		weighted_graph_algorithms graph = new  WGraph_Algo();
		g.addNode(1);
		g.addNode(2);
		g.addNode(3);
		g.addNode(4);
		g.connect(2, 1,18);
		g.connect(2, 3,18);
		g.connect(3, 1,18);
	    graph.init(g);
	    assertFalse(graph.isConnected());
	}
	@Test
		void distance() {
		    weighted_graph g =new WGraph_DS();
			weighted_graph_algorithms graph = new  WGraph_Algo();
			double w=8;
			g.addNode(0);
			g.addNode(1);
			g.addNode(2);
			g.connect(0, 1,5);
			g.connect(1, 2,3);
			g.connect(0, 2,10);
			graph.init(g);
			assertTrue(graph.shortestPathDist(0, 2)==w);
		}
	@Test
	void path() {
	
    weighted_graph g =new WGraph_DS();
	weighted_graph_algorithms graph = new  WGraph_Algo();
	List<node_info> shortestPath = new LinkedList<node_info>();
	g.addNode(0);
	g.addNode(1);
	g.addNode(2);
	g.connect(0, 1,5);
	g.connect(1, 2,3);
	g.connect(0, 2,10);
	shortestPath.add(g.getNode(0));
	shortestPath.add(g.getNode(1));
	shortestPath.add(g.getNode(2));
	graph.init(g);
	assertTrue(shortestPath.equals(graph.shortestPath(0, 2)));

	
	}

  

	

}

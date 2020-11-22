package ex1.src;
import java.util.*;
import java.io.FileOutputStream;
import   java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;


public class WGraph_Algo implements weighted_graph_algorithms,Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2972149042633888906L;
	private weighted_graph graph;

	@Override
	public void init(weighted_graph g) {
		// TODO Auto-generated method stub
		   this.graph = g;// initialization  for graph 
	}

	@Override
	public weighted_graph getGraph() {
		// TODO Auto-generated method stub
		
	        return this.graph;
	  	}

	@Override
	public weighted_graph copy() {
		// TODO Auto-generated method stub

        weighted_graph CopyGraph = new WGraph_DS();
        Iterator<node_info> Itr = this.graph.getV().iterator();
        while (Itr.hasNext()) {
            int N = Itr.next().getKey();
            CopyGraph.addNode(N);
        }
        for (node_info n : this.graph.getV()) {                                     // copy the graph
            for (node_info internalN : this.graph.getV(n.getKey())) {
                CopyGraph.connect(n.getKey(), internalN.getKey(),this. graph.getEdge(n.getKey(), internalN.getKey()));
            }
        }
        return CopyGraph;
	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		 for (node_info n : this.graph.getV()) {// Init all the nodes that are not Visited with  the mark :-1 .
	            n.setTag(0);
	        }
	        Iterator<node_info> iterator = this.graph.getV().iterator();// iterator for the nodes
	        if (iterator.hasNext()) {                               // Check if graph has Nodes Or not
	            NodeInfo node = (NodeInfo) this.graph.getV().iterator().next();//  Save the first node
	            mark(node.getKey());                                 // GO to the secondry method :Mark
	            for (node_info n : this.graph.getV()) {
	                if (n.getTag() == 0)
	                    return false;
	            }
	        } else {
	            return true;//graph is empty
	        }
	        return true;}
	
	
	
	
	 // Recursive function - Marking all Nodes that has been reached  with  1
    private void mark(int key) {
        graph.getNode(key).setTag(1);// modify the Tag of the node
        Iterator<node_info> i = graph.getV(key).iterator();// Iterator for the nodes
        int n;
        while (i.hasNext()) {
            n = i.next().getKey(); // key for all neighbors
            if (graph.getNode(n).getTag() == 0)// if node is not Visited
                mark(n); //send the neighbors to Mark again
        }
    }


    private void dijkstra(node_info s, node_info dest) { //
        if (s.getKey() == dest.getKey() && s.getTag() == 1) {
            return;
        }
        Collection<node_info> ni = this.graph.getV(s.getKey());

        if (ni != null) {
            for (node_info e : ni) {
                double V=((NodeInfo) this.graph.getNode(e.getKey())).getWeight();
                    double Cu_v  =  graph.getEdge(s.getKey(), e.getKey());
                double U=((NodeInfo) this.graph.getNode(s.getKey())).getWeight();
                if (V > U + Cu_v) {
                    ((NodeInfo) this.graph.getNode(e.getKey())).setWeight(((NodeInfo) this.graph.getNode(s.getKey())).getWeight() + graph.getEdge(s.getKey(), e.getKey()));//update the weight
                    s.setTag(1);
                    dijkstra(this.graph.getNode(e.getKey()), dest);
                }
            }
        }
    }


    public void setNodes() {
        Collection<node_info> temp = this.graph.getV();
        for (node_info node : temp) {
            node.setTag(0);
            ((NodeInfo) node).setWeight(Double.POSITIVE_INFINITY);//set the nodes
        }
    }
	

	@Override
	public double shortestPathDist(int src, int dest) {
		// TODO Auto-generated method stub

        if(src== dest ) return 0;
        if(this.graph.getNode(src)==null || this.graph.getNode(dest)==null) return -1;
        setNodes();
        node_info temp = this.graph.getNode(src);
        ((NodeInfo) temp).setWeight(0); // init with the weight 0
        dijkstra(temp, this.graph.getNode(dest));
        if (((NodeInfo)graph.getNode(dest)).getWeight()== Double.POSITIVE_INFINITY)return -1;
        double ans = ((NodeInfo) this.graph.getNode(dest)).getWeight();
        return ans;

}

	@Override
	public List<node_info> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub
		List<node_info> ans = new ArrayList<>();
		if(shortestPathDist(src, dest)==-1)return null;//  no path 
	    this.shortestPathDist(src, dest);
		node_info first = graph.getNode(dest);
		ans.add(first);
	    while (first.getKey() != src) {
			Collection<node_info> temp = graph.getV(first.getKey());
			double check= ((NodeInfo) first).getWeight();
		if(temp!=null) {
				for (node_info e : temp) {
					if (((NodeInfo) graph.getNode(e.getKey())).getWeight() + graph.getEdge(first.getKey(), e.getKey()) == check) {
						first = graph.getNode(e.getKey());
					}
			}
			}
			ans.add(first);
		}
		List<node_info> ans2 = new ArrayList<>();
	   for (int i = ans.size()-1;i>=0;i--){
			ans2.add(ans.get(i));
		}
		return ans2;
	
	
		
		
		
		
		
		
		
		

		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public boolean save(String file) {
		// TODO Auto-generated method stub
		try {
            FileOutputStream graphFile = new FileOutputStream(file);
            ObjectOutputStream OtherGrF = new ObjectOutputStream(graphFile);

            OtherGrF.writeObject(this.graph);

                graphFile.close();
                 OtherGrF.close();
                     return true;
        } catch (IOException ex) {
                     return false;
        }
	}

	@Override
	public boolean load(String file) {
		// TODO Auto-generated method stub
		try {
            FileInputStream graphFile = new FileInputStream(file);
            ObjectInputStream OtherGrF = new ObjectInputStream(graphFile);

            graph = (weighted_graph)
            OtherGrF.readObject();

               OtherGrF.close();
               graphFile.close();
                  return true;
        } catch (IOException ex) {
            return false;
        } catch (ClassNotFoundException ex) {
            return false;
        }
    }
	
















}

package ex1.src;
import java.util.Collection;
import java.util.HashMap;
 import  java.io.Serializable;
import java.util.Iterator;

public class WGraph_DS implements weighted_graph ,Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = -6009330967651177754L;
	private HashMap<Integer, node_info> nodes;//the graph
    private int edgeSize;
    private int mc;
// constructor 

    public WGraph_DS() {
        this.nodes = new HashMap<Integer, node_info>();
        this.edgeSize = 0;
        this.mc = 0;
    }

  //the node_info by the node_id,
	@Override
	public node_info getNode(int key) {
		// TODO Auto-generated method stub
		 return this.nodes.get(key);//get the node_info from hashmap 
	}


   // Check if there is an edge between node1 and node2

	@Override
	public boolean hasEdge(int node1, int node2) {
		// TODO Auto-generated method stub
		if ((this.nodes.get(node1)==null)||(nodes.get(node2)==null)) return false; //if one of them is null return false
		 HashMap<node_info, Double> Nei = ((NodeInfo) nodes.get(node1)).getEdges();//the edges of the node1
       return Nei.containsKey(this.nodes.get(node2));//check if contains node2
	}


	@Override
	public double getEdge(int node1, int node2) {
		// TODO Auto-generated method stub
		HashMap<node_info, Double> NiHash = ((NodeInfo) nodes.get(node1)).getEdges();//the edges of node1 
        if (hasEdge(node1, node2)) return NiHash.get(nodes.get(node2));//return the weight that saved in value of Edges
        return -1;
	}


	@Override
	public void addNode(int key) {
		// TODO Auto-generated method stub
		  node_info n = new NodeInfo(key);
	        this.nodes.put(key, n);// add node with the key 
	        ++mc;//// modify  the mc 
	}


	@Override
	public void connect(int node1, int node2, double w) {
		// TODO Auto-generated method stub
		if (node1 == node2) return;// if tow nodes are equales return null
        boolean check = hasEdge(node1, node2);
        if (check == false) {// if the nodes are not connected 
            edgeSize++;// modify the size
        }// if the nodes are already connected 
        HashMap<node_info, Double> HashN1 = ((NodeInfo) this.nodes.get(node1)).getEdges();
        HashMap<node_info, Double> HashN2 = ((NodeInfo) this.nodes.get(node2)).getEdges();
     
        HashN1.put(this.nodes.get(node2), w);//add to hash of node1
        HashN2.put(this.nodes.get(node1), w);//add to hash of node2
        mc++; // modify the mc 

	}


	@Override
	public Collection<node_info> getV() {
		// TODO Auto-generated method stub
        return this.nodes.values();//return the values of hashmap
	}


	@Override
	public Collection<node_info> getV(int node_id) {
		// TODO Auto-generated method stub
		if ((nodes.get(node_id) == null) || ((NodeInfo) nodes.get(node_id)).getEdges() == null) return null;
        return ((NodeInfo) this.nodes.get(node_id)).getEdges().keySet();//return the keySet of Edges
	}


	@Override
	public node_info removeNode(int key) {
		// TODO Auto-generated method stub

        node_info deletednode = this.nodes.get(key);
        if (deletednode != null) {
            if (((NodeInfo) deletednode).getEdges() != null) {
                {
                    for (node_info n : ((NodeInfo) deletednode).getEdges().keySet()) {
                        ((NodeInfo) n).getEdges().remove(deletednode);// removes nodes from neighbors
                    }
                    this.edgeSize -= ((NodeInfo) deletednode).getEdges().size(); // removes edges 

                    mc++;// modify mc 
                    return nodes.remove(key);

                }
            }

        }
        return null;


	}

	// compartion for 2 graphs
	public boolean equals(Object grp) {
        if (grp instanceof weighted_graph) {
            WGraph_DS graph = (WGraph_DS) grp;


            Iterator<node_info> Itr = this.getV().iterator();
            while (Itr.hasNext()) {
                node_info node = Itr.next();
                if (!graph.nodes.containsValue(node)) return false;//if one  of nodes not equal to other return false
            }
            Iterator<node_info> Iterator = ((WGraph_DS) grp).getV().iterator();
            while (Iterator.hasNext()) {
                node_info node2 = Iterator.next();
                if (!this.nodes.containsValue(node2)) return false;//if one  of nodes not equal to other return false
            }

            
            for (int n : ((WGraph_DS) graph).nodes.keySet()) {
                for (node_info node : ((NodeInfo) graph.nodes.get(n)).getEdges().keySet()) {
                    double weight = ((NodeInfo) graph.nodes.get(n)).getEdges().get(node);
                    if (!hasEdge(n, node.getKey()) || getEdge(n, node.getKey()) != weight)   //if the weight is diffrent return false
                        return false;
                }
            }
                //

                for (int n : (nodes.keySet())) {
                    for (node_info node : ((NodeInfo) nodes.get(n)).getEdges().keySet()) {
                        double W = ((NodeInfo) nodes.get(n)).getEdges().get(node);//Weight
                        if (!graph.hasEdge(n, node.getKey()) || graph.getEdge(n, node.getKey()) != W)////if the weight is diffrent return false
                            return false;
                    }

                }

            


        }
        return true;
    }
	
	
	
	
	
	
	
	
	
	

	@Override
	public void removeEdge(int node1, int node2) {
		// TODO Auto-generated method stub
		 boolean available = hasEdge(node1, node2);
         if (!available) return;
      // if one of the nodes has the other node as a neighbor  in other words if tow nodes are conected 
         ((NodeInfo) this.nodes.get(node2)).getEdges().remove(this.nodes.get(node1));
         ((NodeInfo) this.nodes.get(node1)).getEdges().remove(this.nodes.get(node2));
         edgeSize--;
         mc++;
	}

	// node size 

	@Override
	public int nodeSize() {
		// TODO Auto-generated method stub
        return nodes.size();
	}
	
   // edge size 

	@Override
	public int edgeSize() {
		// TODO Auto-generated method stub
		return edgeSize;
	}
   // mc 

	@Override
	public int getMC() {
		// TODO Auto-generated method stub
		return mc;
	}
}
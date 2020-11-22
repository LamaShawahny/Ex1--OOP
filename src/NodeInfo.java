package ex1.src;

import java.util.HashMap;
import java.io.Serializable;

    public class NodeInfo implements node_info ,Serializable{

        /**
		 * 
		 */
		private static final long serialVersionUID = -23908692495552996L;
		private int key; //the key (id) associated with the node.
        private String Info;
        private double Tag;
        private HashMap<node_info, Double> Edges  ;
        private static int Id=0;
        private  double Weight;
        public NodeInfo() // Default Constructor 
        {
            this.key=Id;
            this.Info = "";
            this.Weight = Double.POSITIVE_INFINITY;
            this.Edges = new HashMap<node_info, Double>();
            this.Tag=0;
            NodeInfo.Id++;
        }
        // another constructors:

        public NodeInfo(int key)
        {
            this.key= key;
            this.Info= "";
            this.Tag=0;
            this.Edges = new HashMap<node_info, Double>();

        }
		@Override
		public int getKey() {
			// TODO Auto-generated method stub
			return this.key;   
		}
		//Set for key
        public void setKey(int k) {
            this.key = k;

        }// get for the Hashmap
        public HashMap  <node_info, Double> getEdges(){
            return this.Edges;}
        
        
        // set for the hashmap
        public void setEdges(HashMap<node_info,Double> E) {
            this.Edges = E;
        }
        
        
        
          public boolean equals(Object Node) {
    		if (Node instanceof NodeInfo) {
    			boolean flag =((NodeInfo) Node).getKey()==key;
    			if(!flag )
    			return false;
    		}
    		return true;
    	}
   
        
       // get for info 
        
		@Override
		public String getInfo() {
			// TODO Auto-generated method stub
			return this.Info;
		}
		// set for info 
		@Override
		public void setInfo(String s) {
			// TODO Auto-generated method stub
			 this.Info = s;
		}
		//get for tag
		@Override
		public double getTag() {
			// TODO Auto-generated method stub
			return this.Tag;
		}
		// set for tag 
		@Override
		public void setTag(double t) {
			// TODO Auto-generated method stub
			this.Tag = t;
		}
		// get for Weight
		 public  double getWeight() {
	            return this.Weight;
	        }
		 //set for weight
		 public void setWeight(double weight) {
		 this.Weight = weight;}
		 public String toString() {
			 return key+"";
		 }

}

# Ex1--OOP
assignment 2
--------------------------------------------------------------
This assignment is an improved deveoloped version of  assignment 1, it works on  developing  a data structure of an undirected weighted graph.
It consists of 3 interfaces and their implementations and a tester.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 node_infointerface <-->NodeInfo class :

*This class represents set of operations applicable on a node (vertex) in an (undirectional) weighted graph.
To implement the graph I used the  collection data structure :hashmap ,Since storing and retrieving elements from the HashMap takes constant O(1) time.
properties :
    int key-the key (id) associated with the node.
    HashMap<node_info, Double> Edges -
    String info-information  associated with the node
    int tag-Temporal data which can be used be algorithms
    int Id - a static Auxiliary variable
    double Weight- the weight



public NodeInfo(): default constructor
 // other constructors:
 public NodeInfo(int key)
 
  getKey() :get for key 
  setKey(int k) :Set for key
  getEdges  : get for the hashmap
  setEdges : set for the hashmap
  getInfo():return the remark (meta data) associated with this node.
  setInfo(string s):  Allows changing the remark (meta data) associated with this node.
  getTag() : get for tag 
  setTag: set for tag 
  getWeight : get for the weight 
  setWeight :set for the weight 
  ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



  Wgraph interface  <-->WGraph_DS class  :

*This class represents an undirectional weighted graph. It supports a large number of nodes , The implementation  based on an efficient compact representation.
To implement this class I used the  collection data structure : hashmap ,Since storing and retrieving elements from the HashMap takes constant O(1) time.
   properties :
private HashMap<Integer, node_info> nodes; hash map for the nodes
    private int edgeSize;the number of edges.
    private int mc;for testing changes in the graph.

    public WGraph_DS() -constructor 

    node_info getNode(int  -the node_data by the node_id-O(1)
    boolean hasEdge(int node1, int node2) -Check if there is an edge between node1 and node2-O(1)
    public double getEdge   -the weight if the edge (node1, node1). In case there is no such edge - should return -1 -O(1)
    public  void addNode(node_data n) -adds a new node to the graph with the given given key.-O(1)
    public void connect(int node1, int node2, double w)- Connect an edge between node1 and node2, with an edge with weight >=0. -O(1)
     Collection<node_data> getV() -return a pointer (shallow copy) for the collection representing all the nodes in the graph -O(1)
    Collection<node_data> getV(int node_id) -This method returns a collection containing all the nodes connected to node_id-O(n)

    node_data removeNode(int key)-  Delete the node (with the given ID) from the graph - and removes all edges which starts or ends at this node. O(1)
     removeEdge(int node1,int node2)- Delete the edge from the graph- O(1)
     int nodeSize ()- the number of vertices (nodes) in the graph.-O(1)
     int edgeSize () -get edges size -O(1)
     int getMC () -get  mc -O(1)
 -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


  Wgraph_algorithms interface  <--> WGraph_Algo class 

*To implement this class I used the Dijkstra  algorithm for finding the shortest paths from source to all vertices in the given graph.
 we generate a SPT (shortest path tree) with given source as root. We maintain two sets, one set contains vertices included in shortest path tree, other set includes vertices not yet included in shortest path tree. At every step of the algorithm, we find a vertex which is in the other set (set of not yet included) and has a minimum distance from the source.

  properties :
  weighted_graph graph;- The graph 
  main methods:
    void init(graph g) :Init the graph on which this set of algorithms operates on.
    weighted_graph getGraph() : underlying graph of which this class works.
    boolean isConnected() : Check if there is a valid path from EVREY node to each other node.
     int shortestPathDist(int src, int dest)    :returns the length of the shortest path between src to dest
    List<node_data> shortestPath :returns the the shortest path between src to dest - as an ordered List of nodes: src--> n1-->n2-->...dest
 
  secondary methods :
   Void Dijkstra(node_info s,node_info dest)
    Void Mark (int key ) - recurse method travels from nighbor to another .
   ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
sources:
https://moodlearn.ariel.ac.il/mod/url/view.php?id=1257977
https://www.coursera.org/lecture/advanced-data-structures/core-dijkstras-algorithm-2ctyF
https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
https://www.youtube.com/watch?v=XB4MIexjvY0
Dijkstra נושא 7 המסלול הקצר ביותרקובץ
assignment 0 .


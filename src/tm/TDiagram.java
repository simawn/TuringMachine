package tm;

import java.util.HashMap;

//directed graph
public class TDiagram {
	
	class Vertex {
		private int state;
		private HashMap<Character, Edge> edgeList; //Using read char as key: <read character, edge object>
		// If read = null, transition DNE, halts.
		
		public Vertex(int state) {
			this.state = state;
			edgeList = new HashMap<Character, Edge>();
			//System.out.println("vertex: " + state + " added.");
		}
		
		public void addEdge(int from, int to, char read, char write, char move) {
			this.edgeList.put(read, new Edge(from, to, read, write, move));
		}

		public int getState() {
			return state;
		}

		public HashMap<Character, Edge> getEdgeList() {
			return edgeList;
		}
		
	}
	
	class Edge {
		private int from;
		private int to;
		private char read;
		private char write;
		private char move;
		
		public Edge(int from, int to, char read, char write, char move) {
			this.from = from;
			this.to = to;
			this.read = read;
			this.write = write;
			this.move = move;
			//System.out.println("Edge added: " + this.from + this.to + this.read + this.write + this.move);
		}

		public int getFrom() {
			return from;
		}

		public int getTo() {
			return to;
		}

		public char getRead() {
			return read;
		}

		public char getWrite() {
			return write;
		}

		public char getMove() {
			return move;
		}
		
	}
	
	private HashMap<Integer, Vertex> adjList;
	
	public TDiagram() {
		this.adjList = new HashMap<Integer, Vertex>();
	}
	
	public void addData(int currState, char read, int nextState, char write, char move) { //This is the data from the input file
		//Check if key(vertex), if not, create a new vertex and add the edge, otherwise, add a new edge to the existing vertex
		if(this.adjList.get(currState) != null) {
			this.addEdge(currState, nextState, read, write, move);
		} else {
			this.addVertex(currState);
			this.addEdge(currState, nextState, read, write, move);
		}
	}
	
	//Merge addVertex and addEdge together? 
	private void addVertex(int state) {
		this.adjList.put(state, new Vertex(state));
	}
	
	private void addEdge(int from, int to, char read, char write, char move) {
		this.adjList.get(from).addEdge(Character.toLowerCase(from), Character.toLowerCase(to), Character.toLowerCase(read), Character.toLowerCase(write), Character.toLowerCase(move));
	}

	public HashMap<Integer, Vertex> getAdjList() {
		return adjList;
	}
}

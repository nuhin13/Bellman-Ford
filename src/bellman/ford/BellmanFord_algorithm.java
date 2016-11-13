/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bellman.ford;

/**
 *
 * @author nuhin13
 */
public class BellmanFord_algorithm {
    
     private int distances[];
    private int numberofvertices;
    public static final int MAX_VALUE = 999;
 
    public BellmanFord_algorithm(int numberofvertices)
    {
        this.numberofvertices = numberofvertices;
        distances = new int[numberofvertices + 1];
    }
 
    public void BellmanFordEvaluation(int source, int adjacencymatrix[][])
    {
        for (int node = 1; node <= numberofvertices; node++)
        {
            distances[node] = MAX_VALUE;
        }
 
        distances[source] = 0;
        for (int node = 1; node <= numberofvertices - 1; node++)
        {
            for (int sourcenode = 1; sourcenode <= numberofvertices; sourcenode++)
            {
                for (int destinationnode = 1; destinationnode <= numberofvertices; destinationnode++) { if (adjacencymatrix[sourcenode][destinationnode] != MAX_VALUE) { if (distances[destinationnode] > distances[sourcenode] 
                                + adjacencymatrix[sourcenode][destinationnode])
                            distances[destinationnode] = distances[sourcenode]
                                + adjacencymatrix[sourcenode][destinationnode];
                    }
                }
            }
        }
 
        for (int sourcenode = 1; sourcenode <= numberofvertices; sourcenode++)
        {
            for (int destinationnode = 1; destinationnode <= numberofvertices; destinationnode++) { if (adjacencymatrix[sourcenode][destinationnode] != MAX_VALUE) { if (distances[destinationnode] > distances[sourcenode]
                           + adjacencymatrix[sourcenode][destinationnode])
                        System.out.println("The Graph contains negative egde cycle");
                }
            }
        }
 
        for (int vertex = 1; vertex <= numberofvertices; vertex++)
        {
            System.out.println("distance of source  " + source + " to "
                      + vertex + " is " + distances[vertex]);
        }
    }
 
}

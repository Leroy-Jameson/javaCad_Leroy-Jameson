// Create a cube
import eu.mihosoft.vrl.v3d.STL;
import eu.mihosoft.vrl.v3d.RoundedCube;
import eu.mihosoft.vrl.v3d.Text;

double size =40;
CSG cube = new Cube(	size,// X dimention
			size,// Y dimention
			size//  Z dimention
			).toCSG()
CSG roundedCube = new RoundedCube(	size,// X dimention
				size,// Y dimention
				size//  Z dimention
				)
				.cornerRadius(size/10)
				.toCSG()
CSG text = Text.text(10.0, "Hello", new Font("Helvedica", Font.PLAIN, 18))
					
//create a sphere
CSG sphere = new Sphere(size/20*12.5).toCSG()
CSG cylinder = new Cylinder(	size/4, // Radius at the top
				size/2, // Radius at the bottom
				size, // Height
			         (int)80 //resolution
			         ).toCSG()
CSG polygon = Extrude.points(new Vector3d(0, 0, size),// This is the  extrusion depth
                new Vector3d(0,0),// All values after this are the points in the polygon
                new Vector3d(size*2,0),// Bottom right corner
                new Vector3d(size*1.5,size),// upper right corner
                new Vector3d(size/2,size)// upper left corner
        );		         
//perform a difference
// perform union, difference and intersection
CSG cubePlusSphere = cube.union(sphere);
CSG cubeMinusSphere = cube.difference(sphere);
CSG cubeIntersectSphere = cube.intersect(sphere);
// translate geometries to prevent overlapping 
CSG union = cube.union(
	sphere.movey(size*1.5),
        cubePlusSphere.movey(size*3),
        cubeMinusSphere.movey(size*5),
        cubeIntersectSphere.movey(size*7),
        cylinder.movex(size*3),
        polygon.movex(size*5),
        roundedCube.movex(size*8),
        text.movex(size*12)
        );

public class NBody { //simulate a universe specified in the file
    public static double readRadius(String filename) {
        In in = new In(filename);
        int N = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String fbname) {
        In in = new In(fbname);
        int count = 0;

        int plnum = in.readInt();
        double gar2 = in.readDouble(); //read the first two items
        Planet[] allbodys = new Planet[plnum];
        while (!in.isEmpty()) {
            if (count == plnum) {
                break;
            }
            double posX = in.readDouble();
            double posY = in.readDouble();
            double velX = in.readDouble();
            double velY = in.readDouble();
            double mass = in.readDouble();
            String fname = in.readString();
            Planet cur = new Planet(posX, posY, velX, velY, mass, fname);
            allbodys[count] = new Planet(cur);
            count += 1;
        }
        return allbodys;
    }

    //something wrong with this drawplanets
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] allbodies = readPlanets(filename);
        int length = allbodies.length;
        String imagetodraw = "images/starfield.jpg"; //draw image as background
        StdDraw.enableDoubleBuffering();

        double time = 0.0;
        while (time < T) {
            //calculate the net x,y forces for each body and store in array
            double tempsum = 0.0;
            Double[] xForces = new Double[length];
            Double[] yForces = new Double[length];
            int i = 0;
            for (Planet single : allbodies) { //calculate the net force for each direction
                double currentx = single.calcNetForceExertedByX(allbodies);
                double currenty = single.calcNetForceExertedByY(allbodies);
                xForces[i] = currentx;
                yForces[i] = currenty;
                i += 1;
            }
            StdDraw.setScale(-radius, radius);
            StdDraw.picture(0, 0, imagetodraw);
            int j = 0;
            for (Planet one : allbodies) {
                one.update(time, xForces[j], yForces[j]);
                one.draw();
                j += 1;
            }
            StdDraw.show();
            StdDraw.pause(20);
            time += dt;
//        StdDraw.setScale(-radius, radius); //set scale first to set up right coordinates
//        StdDraw.picture(0,0, imagetodraw); //then draw picture, you dummy
//        //draw one body
//        for (Planet s : allbodies) {
//            s.draw();
//        }
////        StdDraw.show();

        }
        //printing the universe
        System.out.println(length);
        System.out.println(radius);
        for (Planet fi : allbodies) {
            System.out.println(fi.xxPos + fi.yyPos + fi.xxVel + fi.yyVel + fi.mass + fi.imgFileName);
        }

    }
} //missing one curly bracket

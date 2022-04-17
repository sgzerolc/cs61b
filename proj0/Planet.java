public class Planet {
    public double xxPos; //declare variables
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Planet(double xP, double yP, double xV, double yV, double m, String img) { //constructor
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet b) {  //how to initialize and then copy body b; the way bellow is different approach.
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.mass = b.mass;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.imgFileName = b.imgFileName;
    }

    public double calcDistance(Planet fornow) {
        double xdif = this.xxPos - fornow.xxPos;
        double ydif = this.yyPos - fornow.yyPos;
        double squaredis = (xdif*xdif + ydif*ydif);
        double distance = java.lang.Math.sqrt(squaredis);
        return distance;
    }

    public double calcForceExertedBy(Planet ego){
        if (this.equals(ego)) {
            return 0;
        }
        double constant = 6.67e-11;
        double distance = this.calcDistance(ego);
        double force = (constant * this.mass * ego.mass)/(distance * distance);
        return force;
    }

    public double calcForceExertedByX(Planet another){
        double distance = this.calcDistance(another);
        double force = this.calcForceExertedBy(another);
        double xdif = another.xxPos - this.xxPos;
//        if (xdif < 0){
//            xdif = - xdif;
//        }
        double forceX = (force * xdif)/distance;
        return forceX;
    }

    public double calcForceExertedByY(Planet another){
        double distance = this.calcDistance(another);
        double force = this.calcForceExertedBy(another);
        double ydif = another.yyPos - this.yyPos;
//        if (ydif < 0){
//            ydif = - ydif;
//        }
        double forceY = ((force * ydif)/distance);
        return forceY;
    }

    public double calcNetForceExertedByX(Planet[] allbodys){
        double netforceX = 0;
        for (Planet single : allbodys) {
            if (this.equals(single)) {
                continue;
            }
            netforceX += calcForceExertedByX(single);
        }
        return netforceX;
    }

    public double calcNetForceExertedByY(Planet[] allbodys){
        double netforceY = 0;
        for (Planet single : allbodys) {
            if (this.equals(single)) {
                continue;
            }
            netforceY += calcForceExertedByY(single);
        }
        return netforceY;
    }

    public void update(double time, double forceX, double forceY) {
        double aX = forceX / this.mass;
        double aY = forceY / this.mass;
        double vX = this.xxVel + time * aX;
        double vY = this.yyVel + time * aY;
        double posX = this.xxPos + time * vX;
        double posY = this.yyPos + time * vY;
        this.xxVel = vX;
        this.yyVel = vY;
        this.xxPos = posX;
        this.yyPos = posY;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }


}

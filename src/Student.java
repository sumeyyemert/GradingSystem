public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    double grade;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAverage();
        this.isPass = false;
    }


    public void addBulkExamNote(int mat, int fizik, int kimya) {

        if (mat >= 0 && mat <= 100) {
            this.mat.note = mat;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.note = fizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.note = kimya;
        }

    }

    public void addBulkExamNote2(int mat, int fizik, int kimya){
        if (mat >= 0 && mat <= 100) {
            this.mat.note2 = mat;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.note2 = fizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.note2 = kimya;
        }

    }

    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0
                || this.mat.note2 == 0 || this.fizik.note2 == 0 || this.kimya.note2 == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Geçme notu : " + this.grade);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAverage() {
        this.avarage = (this.fizik.note + this.kimya.note + this.mat.note) / 3;
    }
    public void calcGrade(){
        this.grade = ((this.fizik.note2 + this.kimya.note2 + this.mat.note2)/3*0.20) + (avarage*0.80);
    }

    public boolean isCheckPass() {
        calcGrade();
        return this.grade > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Fizik Notu : " + this.fizik.note);
        System.out.println("Kimya Notu : " + this.kimya.note);
    }

}
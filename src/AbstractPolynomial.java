abstract class AbstractPolynomial {
   DList<Term> data = null;
   public AbstractPolynomial() {
      data = new DList<>();
   }
   public final String toString() {
      String ans = "";
      boolean starting = true;
      try {
         DNode<Term> n = data.getFirst();
         while (n != null) {
            if (!starting && n.getData().isPositive()) ans += " +";
            starting = false;
            ans += " " + n.getData().toString();
            n = data.getNext(n);
         }
      } catch (Exception e) {
         if (starting) return "0";
      }
      return ans;
   }
  abstract public DList<Term> add(AbstractPolynomial p);
  abstract public DList<Term> subtract(AbstractPolynomial p);
  abstract public DList<Term> multiply(AbstractPolynomial p);
}
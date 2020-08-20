package com.pjh.example.lambda;

public class PhonePriceLambda {

    public static void main(final String[] args){

        Phone phone = new Phone() {
            @Override
            public String makeEvent(Product.Name name, Product.Sale sale) {
                return String.format("%s ! %d  sale", name.name(), sale.getPersent());
            }
        };

        //lambda
        Phone phoneLambda = (Phone.Product.Name name, Phone.Product.Sale sale) -> String.format("%s ! %d  sale", name.name(), sale.getPersent());

        System.out.println(String.format("iphone.makeEvent() -> %s", phone.makeEvent(Phone.Product.Name.IPhone11, Phone.Product.Sale.BIG_EVENT)));
        System.out.println(String.format("samsung.makeEvent() -> %s", phone.makeEvent(Phone.Product.Name.NOTE20Plus, Phone.Product.Sale.SMALL_EVENT)));
        System.out.println();
        System.out.println(String.format("iphoneLambda.makeEvent() -> %s", phoneLambda.makeEvent(Phone.Product.Name.IPhone11, Phone.Product.Sale.BIG_EVENT)));
        System.out.println(String.format("samsungLambda.makeEvent() -> %s", phoneLambda.makeEvent(Phone.Product.Name.NOTE20Plus, Phone.Product.Sale.SMALL_EVENT)));
    }
}

@FunctionalInterface
interface Phone{
    interface Product{
        enum Name{
            NOTE20Plus, IPhone11
        }
        enum Sale{
            BIG_EVENT(20), SMALL_EVENT(5);

            private final int percent;

            Sale(int percent){
                this.percent = percent;
            }

            public int getPersent(){
               return percent;
            }
        }
    }
    String makeEvent(Product.Name name, Product.Sale sale);
}

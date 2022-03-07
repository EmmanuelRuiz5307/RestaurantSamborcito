package restaurant;

import java.io.*;

public class Restaurant {

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String orderNameM[] = {" ", "Sopes", "Flautas Res y Pollo", "Chilaquiles Sencillos", "Quesadillas Samborcito", "Churros", "Fresas con crema", "Rebanada de pastel", "Flan", "Coca Cola", "Agua de Jamaica", "CHOCOMILK", "LICUADO 1L"};
        String orderNameP[] = {" ", "Sopes\t$ 20.00", "Flautas Res y Pollo\t$ 75.00", "Chilaquiles Sencillos\t$ 70.00", "Quesadillas Samborcito\t$ 130.00",
            "Churros\t\t$ 25.00", "Fresas con crema\t\t$ 20.00", "Rebanada de Pastel\t\t$ 30.00", "Flan\t$ 40.00",
            "Coca Cola\t\t\t$ 30.00", "Agua de Jamaica\t\t\t$ 25.00", "CHOCOMILK\t\t\t$ 25.00", "LICUADO 1L\t\t\t$ 25.00"};
//                                  ANTOJITOS                     | POSTRES                    | BEBIDAS
        double orderPrice[] = {0.00, 20.00, 75.00, 70.00, 130.00, 25.00, 20.00, 30.00, 40.00, 30.0, 25.00, 25.00, 25.00};
        String user, pass, search, again = "", mainQ = "", mainQ2 = "", dessertQ = "", dessertQ2 = "", drinksQ = "", drinksQ2 = "";

        int a = 0, b = 0, c = 0, d = 0, e = 1, g = 0, h = 0, i = 0, r = 0, choice = 0, choice1 = 0, order = 0, table = 1, end = 0;
        String producto_agotado = "\t*No disponible*";
        String orderString[][] = new String[50][20];
        String orderStringM[][] = new String[20][20];
        String orderStringP[][] = new String[20][20];
        double orderMDouble[][] = new double[50][20];
        double orderDDouble[][] = new double[50][20];
        double tableNo[] = new double[21];
        double pieces[] = new double[13];
        double paid[] = new double[21];
        double totalOrder[] = new double[50];
        double payment, change = 0;
        double totalPrice[] = new double[21];
        double orderDouble[][] = new double[21][20];

        for (int z = 1; z <= 12; z++) {
            pieces[z] = 20;
        }

        while (a < 3) {
            System.out.print("\nUsuario: ");
            user = in.readLine();
            System.out.print("\nContraseña: ");
            pass = in.readLine();

            if (user.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin")) {

                System.out.println("\n ******************************************************");
                System.out.println(" ********** BIENVENIDO AL SAMBORCITO DE MARGOT **********");
                System.out.println(" *******************************************************");

                do {
                    System.out.println("\n **************************************");
                    System.out.println(" ********** M E N U **********");
                    System.out.println(" **************************************");
                    System.out.println(" (1) Pedido");
                    System.out.println(" (2) Información del pedido");
                    System.out.println(" (3) Facturación");
                    System.out.println(" (4) Inventario de platillos");
                    System.out.println(" (5) Salir");
                    System.out.println(" *************************************");

                    for (int f = 1; f == 1;) {

                        System.out.print("\nEligue una opción: ");
                        choice = Integer.parseInt(in.readLine());

                        //OPCION 1 - "PLATILLO"
                        if (choice == 1) {
                            do {
                                for (int z = 1; z <= 12; z++) {
                                    orderString[b][z] = "0";
                                }
                                for (int x = 1; x == 1;) {
                                    System.out.print("\nNombre del consumidor: ");
                                    //System.out.print("\nEnter Customer Name: ");
                                    orderString[b][0] = in.readLine();

                                    x = 0;

                                    for (int l = 0; l < b; l++) {
                                        if (orderString[l][0].equalsIgnoreCase(orderString[b][0])) {
                                            //   System.out.println("Customer Name Already Used!");
                                            System.out.println("Nombre del Cliente ya utilizado");
                                            x = 1;
                                        }
                                    }
                                }

                                c = 0;
                                System.out.println("\n *************************************");
                                System.out.println(" ************* CARTA DE PLATILLOS ************* ");
                                System.out.println(" *************************************");
                                System.out.println("\n    ********** ANTOJITOS MEXICANOS **********");
                                System.out.print(" SOPES \t\t\t\t$ 20.00");
                                if (pieces[1] > 0) {
                                    System.out.println("\t" + pieces[1] + "pzas.");
                                } else {
                                    System.out.println(producto_agotado);
                                }
                                System.out.print(" Flautas Res y Pollo \t\t$ 75.00");
                                if (pieces[2] > 0) {
                                    System.out.println("\t" + pieces[2] + "pzas.");
                                } else {
                                    System.out.println(producto_agotado);
                                }
                                System.out.print(" Chilaquiles Sencillos\t\t$ 70.00");
                                if (pieces[3] > 0) {
                                    System.out.println("\t" + pieces[3] + "pzas.");
                                } else {
                                    System.out.println(producto_agotado);
                                }
                                System.out.print(" Quesadillas Samborcito \t$ 130.00");
                                if (pieces[4] > 0) {
                                    System.out.println(" " + pieces[4] + "pzas.");
                                } else {
                                    System.out.println(producto_agotado);
                                }
                                System.out.println("\n    *********** POSTRES ***********");
                                System.out.print(" Churros \t\t\t$ 25.00");
                                if (pieces[5] > 0) {
                                    System.out.println(" " + pieces[5] + "pzas.");
                                } else {
                                    System.out.println(producto_agotado);
                                }
                                System.out.print(" Fresas con crema \t\t$ 20.00");
                                if (pieces[6] > 0) {
                                    System.out.println(" " + pieces[6] + "pzas.");
                                } else {
                                    System.out.println(producto_agotado);
                                }
                                System.out.print(" Rebanada de pastel \t\t$ 30.00");
                                if (pieces[7] > 0) {
                                    System.out.println(" " + pieces[7] + "pzas.");
                                } else {
                                    System.out.println(producto_agotado);
                                }
                                System.out.print(" Flan \t\t\t        $ 40.00");
                                if (pieces[8] > 0) {
                                    System.out.println(" " + pieces[8] + "pzas.");
                                } else {
                                    System.out.println(producto_agotado);
                                }
                                System.out.println("\n    *********** BEBIDAS ************");
                                System.out.print("COCA COLA \t\t\t$ 30.00");
                                if (pieces[9] > 0) {
                                    System.out.println("\t" + pieces[9] + "pzas.");
                                } else {
                                    System.out.println(producto_agotado);
                                }
                                //System.out.print(" 2. Sprite \t\t\t$ 30.00");
                                System.out.print("AGUA \t\t\t\t$ 25.00");
                                if (pieces[10] > 0) {
                                    System.out.println(" " + pieces[10] + "pzas.");
                                } else {
                                    System.out.println(producto_agotado);
                                }
                                //System.out.print(" 3. Pepsi \t\t\t$ 25.00");
                                System.out.print("CHOCOMILK \t\t\t$ 25.00");
                                if (pieces[11] > 0) {
                                    System.out.println("\t" + pieces[11] + "pzas.");
                                } else {
                                    System.out.println(producto_agotado);
                                }
                                //System.out.print(" 4. 7-Up \t\t\t$ 25.00");
                                System.out.print("LICUADO 1L \t\t\t$ 25.00");
                                if (pieces[12] > 0) {
                                    System.out.println("\t" + pieces[12] + "pzas.");
                                } else {
                                    System.out.println(producto_agotado);
                                }
                                System.out.println(" *************************************");

                                if (pieces[1] == 0 && pieces[2] == 0 && pieces[3] == 0 && pieces[4] == 0) {
                                    System.out.println(producto_agotado);
                                } else {
                                    for (int v = 1; v == 1;) {
                                        //  System.out.print("\nDo you want to order MAIN DISH? [Y/N]: ");
                                        System.out.print("\n¿Desea ordenar algo de ANTOJITOS MEXICANOS? [Y/N]: ");
                                        mainQ = in.readLine();

                                        //MAIN DISH
                                        if (mainQ.equalsIgnoreCase("y")) {

                                            do {
                                                System.out.println("\n\t ********** ANTOJITOS MEXICANOS **********");
                                                System.out.println(" **************************************");
                                                System.out.println(" NOMBRE\t\t\t\tPRECIO");
                                                System.out.print(" 1. SOPES \t\t\t\t$ 20.00");
                                                if (pieces[1] > 0) {
                                                    System.out.println("\t" + pieces[1] + "pzas.");
                                                } else {
                                                    System.out.println(producto_agotado);
                                                }
                                                System.out.print(" 2. Flautas Res y Pollo \t\t$ 75.00");
                                                if (pieces[2] > 0) {
                                                    System.out.println("\t" + pieces[2] + "pzas.");
                                                } else {
                                                    System.out.println(producto_agotado);
                                                }
                                                System.out.print(" 3. Chilaquiles Sencillos\t\t$ 70.00");
                                                if (pieces[3] > 0) {
                                                    System.out.println("\t" + pieces[3] + "pzas.");
                                                } else {
                                                    System.out.println(producto_agotado);
                                                }
                                                System.out.print(" 4. Quesadillas Samborcito \t$ 130.00");
                                                if (pieces[4] > 0) {
                                                    System.out.println(" " + pieces[4] + "pzas.");
                                                } else {
                                                    System.out.println(producto_agotado);
                                                }
                                                for (e = 1; e == 1;) {
                                                    System.out.print("\nIngresa tu orden: ");
                                                    order = Integer.parseInt(in.readLine());

                                                    for (v = 1; v <= 4; v++) {
                                                        if (order == v) {
                                                            if (orderString[b][v].equals("1")) {
                                                                System.out.println("Antojito Mexicano ha sido agregado anteriormente...");
                                                                e = 1;
                                                            } else if (pieces[v] == 0) {
                                                                System.out.println("Antojitos Mexicanos no disponibles");
                                                                e = 1;
                                                            } else {
                                                                e = 0;
                                                            }
                                                        }
                                                    }
                                                    if (order < 1 || order > 4) {
                                                        System.out.println("Entrada Invalida!");
                                                        e = 1;
                                                    }

                                                }

                                                do {
                                                    System.out.print("¿Cuantos? : ");
                                                    orderMDouble[b][c] = Double.parseDouble(in.readLine());

                                                    for (v = 1; v <= 4; v++) {
                                                        if (order == v) {
                                                            orderString[b][v] = "1";
                                                            pieces[v] = pieces[v] - orderMDouble[b][c];
                                                            if (pieces[v] < 0) {
                                                                pieces[v] = pieces[v] + orderMDouble[b][c];
                                                                System.out.println("Lo sentimos, solamente tenemos " + pieces[v] + "pzas. Disponibles");
                                                                v = 5;
                                                                r = 1;
                                                            } else {
                                                                r = 0;
                                                            }
                                                        }
                                                    }
                                                } while (r == 1);

                                                orderStringP[b][c] = orderNameP[order];
                                                orderStringM[b][c] = orderNameM[order];
                                                orderDouble[b][c] = orderPrice[order];

                                                c++;
                                                for (d = 1; d == 1;) {
                                                    //System.out.print("\nWant to Order Other MAIN DISH? [Y/N]: ");
                                                    System.out.print("¿Quiere ordenar otros ANTOJITOS MEXICANOS? [Y/N]:");
                                                    mainQ2 = in.readLine();

                                                    if (mainQ2.equalsIgnoreCase("y")) {
                                                        d = 0;
                                                    } else if (mainQ2.equalsIgnoreCase("n")) {
                                                        System.out.print("");
                                                        d = 0;
                                                    } else {
                                                        System.out.print("Entrada Invalida!");
                                                        d = 1;
                                                    }
                                                }
                                                if (orderString[b][1].equals("1") && orderString[b][2].equals("1") && orderString[b][3].equals("1") && orderString[b][4].equals("1")) {
                                                    //  System.out.println("\nSorry, You order all 4 MAIN DISH!");
                                                    System.out.println("\nLo setimos, usted ordeno todos los ANTOJITOS MEXICANOS");
                                                    mainQ2 = "n";
                                                }
                                                if (pieces[1] == 0 && pieces[2] == 0 && pieces[3] == 0 && pieces[4] == 0) {
                                                    //System.out.println("\nMain Dish Not Available!");
                                                    System.out.println("\nANTOJITOS MEXICANOS no disponibles!");
                                                    mainQ2 = "n";
                                                }
                                            } while (mainQ2.equalsIgnoreCase("y"));

                                        } else if (mainQ.equalsIgnoreCase("n")) {
                                            v = 0;
                                        } else {
                                            System.out.print("Etrada invalida!");
                                            v = 1;
                                        }
                                    }
                                }
                                if (pieces[5] == 0 && pieces[6] == 0 && pieces[7] == 0 && pieces[8] == 0) {
                                    System.out.println("\nAntojitos Mexicanos no disponibles!");
                                } else {
                                    for (int v = 1; v == 1;) {
                                        //System.out.print("\nDo you want to order DESSERT? [Y/N]: ");
                                        System.out.print("\n¿Desea ordenar algo de POSTRES? [Y/N]: ");
                                        dessertQ = in.readLine();

                                        //DESSERT
                                        if (dessertQ.equalsIgnoreCase("y")) {
                                            do {
                                                System.out.println("\n\t ********** POSTRES **********");
                                                System.out.println(" **************************************");
                                                System.out.println(" NOMBRE\t\t\t\tPRECIO - PIEZAS");
                                                System.out.print(" 1. Churros \t\t\t$ 25.00");
                                                if (pieces[5] > 0) {
                                                    System.out.println(" " + pieces[5] + "pzas.");
                                                } else {
                                                    System.out.println(producto_agotado);
                                                }
                                                System.out.print(" 2. Fresas con crema \t\t$ 20.00");
                                                if (pieces[6] > 0) {
                                                    System.out.println(" " + pieces[6] + "pzas.");
                                                } else {
                                                    System.out.println(producto_agotado);
                                                }
                                                System.out.print(" 3. Rebanada de pastel \t\t$ 30.00");
                                                if (pieces[7] > 0) {
                                                    System.out.println(" " + pieces[7] + "pzas.");
                                                } else {
                                                    System.out.println(producto_agotado);
                                                }
                                                System.out.print(" 4. Flan \t\t        $ 40.00");
                                                if (pieces[8] > 0) {
                                                    System.out.println(" " + pieces[8] + "pzas.");
                                                } else {
                                                    System.out.println(producto_agotado);
                                                }
                                                System.out.println(" **************************************");

                                                for (e = 1; e == 1;) {
                                                    // System.out.print("\nEnter Your Order: ");
                                                    System.out.print("\nIngresa tu orden: ");
                                                    order = Integer.parseInt(in.readLine());
                                                    order = order + 4;

                                                    for (v = 5; v <= 8; v++) {
                                                        if (order == v) {
                                                            if (orderString[b][v].equals("1")) {
                                                                System.out.println("El postre ha sido agregado anteriormente...!");
                                                                e = 1;
                                                            } else if (pieces[v] == 0) {
                                                                System.out.println("POSTRES no disponibles");
                                                                e = 1;
                                                            } else {
                                                                e = 0;
                                                            }
                                                        }
                                                    }
                                                    if (order < 5 || order > 8) {
                                                        System.out.println("Entrada Invalida!");
                                                        e = 1;
                                                    }
                                                }

                                                do {
                                                    System.out.print("¿Cuantos? : ");
                                                    orderMDouble[b][c] = Double.parseDouble(in.readLine());

                                                    for (v = 5; v <= 8; v++) {
                                                        if (order == v) {
                                                            orderString[b][v] = "1";
                                                            pieces[v] = pieces[v] - orderMDouble[b][c];
                                                            if (pieces[v] < 0) {
                                                                pieces[v] = pieces[v] + orderMDouble[b][c];
                                                                //System.out.println("Sorry, We only have " + pieces[v] + "pzas. Available");
                                                                System.out.println("Lo sentimos, solamente tenemos " + pieces[v] + "pzas. Disponibles");
                                                                v = 9;
                                                                r = 1;

                                                            } else {
                                                                r = 0;
                                                            }
                                                        }

                                                    }
                                                } while (r == 1);

                                                orderStringP[b][c] = orderNameP[order];
                                                orderStringM[b][c] = orderNameM[order];
                                                orderDouble[b][c] = orderPrice[order];

                                                c++;

                                                for (d = 1; d == 1;) {
                                                    // System.out.print("\nWant to Order Other DESSERT? [Y/N]: ");
                                                    System.out.print("\n¿Quiere ordenar otros POSTRES? [Y/N]: ");
                                                    dessertQ2 = in.readLine();

                                                    if (dessertQ2.equalsIgnoreCase("y")) {
                                                        d = 0;
                                                    } else if (dessertQ2.equalsIgnoreCase("n")) {
                                                        d = 0;
                                                        dessertQ = "n";
                                                    } else {
                                                        System.out.print("Entrada Invalida!");
                                                        d = 1;
                                                    }
                                                }
                                                if (orderString[b][5].equals("1") && orderString[b][6].equals("1") && orderString[b][7].equals("1") && orderString[b][8].equals("1")) {
                                                    System.out.println("\nLo setimos, usted ordeno todos los POSTRES");
                                                    dessertQ2 = "n";
                                                }
                                                if (pieces[1] == 0 && pieces[2] == 0 && pieces[3] == 0 && pieces[4] == 0) {
                                                    System.out.println("\nPOSTRES NO DISPONIBLES");
                                                    dessertQ2 = "n";
                                                }
                                            } while (dessertQ2.equalsIgnoreCase("y"));

                                        } else if (dessertQ.equalsIgnoreCase("n")) {
                                            v = 0;
                                        } else {
                                            System.out.print("Entrada Invalida!");
                                            v = 1;
                                        }
                                    }
                                }
                                if (pieces[5] == 0 && pieces[6] == 0 && pieces[7] == 0 && pieces[8] == 0) {
                                    // System.out.println("\nDessert Not Available!");
                                    System.out.println("POSTRES NO DISPONIBLES");
                                } else {
                                    for (int v = 1; v == 1;) {
                                        //  System.out.print("\nDo you want to Order DRINKS? [Y/N]: ");
                                        System.out.print("\n¿Desea ordenar una BEBIDA? [Y/N]: ");
                                        drinksQ = in.readLine();

                                        //DRINKS
                                        if (drinksQ.equalsIgnoreCase("y")) {

                                            do {
                                                System.out.println("\n\t ********** BEBIDAS **********");
                                                System.out.println(" **************************************");
                                                System.out.println(" NOMBRE\t\t\t\tPRECIO - PIEZAS");
                                                //System.out.print(" 1. Coke \t\t\t$ 30.00");
                                                System.out.print(" 1. COCA COLA \t\t\t$ 30.00");
                                                if (pieces[9] > 0) {
                                                    System.out.println("\t" + pieces[9] + "pzas.");
                                                } else {
                                                    System.out.println(producto_agotado);
                                                }
                                                //System.out.print(" 2. Sprite \t\t\t$ 30.00");
                                                System.out.print(" 2. AGUA \t\t\t$ 25.00");
                                                if (pieces[10] > 0) {
                                                    System.out.println("\t" + pieces[10] + "pzas.");
                                                } else {
                                                    System.out.println(producto_agotado);
                                                }
                                                //System.out.print(" 3. Pepsi \t\t\t$ 25.00");
                                                System.out.print(" 3. CHOCOMILK \t\t\t$ 25.00");
                                                if (pieces[11] > 0) {
                                                    System.out.println("\t" + pieces[11] + "pzas.");
                                                } else {
                                                    System.out.println(producto_agotado);
                                                }
                                                //System.out.print(" 4. 7-Up \t\t\t$ 25.00");
                                                System.out.print(" 4. LICUADO 1L \t\t\t$ 25.00");
                                                if (pieces[12] > 0) {
                                                    System.out.println("\t" + pieces[12] + "pzas.");
                                                } else {
                                                    System.out.println(producto_agotado);
                                                }
                                                System.out.println(" **************************************");

                                                for (e = 1; e == 1;) {
                                                    //  System.out.print("\nEnter Your Order: ");
                                                    System.out.print("\nIngresa tu orden: ");
                                                    order = Integer.parseInt(in.readLine());
                                                    order = order + 8;

                                                    for (v = 9; v <= 12; v++) {
                                                        if (order == v) {
                                                            if (orderString[b][v].equals("1")) {
                                                                System.out.println("La bebida ha sido agregada anteriormente!");
                                                                e = 1;
                                                            } else if (pieces[v] == 0) {
                                                                System.out.println("BEBIDAS NO DISPONIBLES");
                                                                e = 1;
                                                            } else {
                                                                e = 0;
                                                            }
                                                        }
                                                    }
                                                    if (order < 9 || order > 12) {
                                                        System.out.println("Entrada invalida!");
                                                        e = 1;
                                                    }
                                                }

                                                orderStringP[b][c] = orderNameP[order];
                                                orderStringM[b][c] = orderNameM[order];
                                                orderDouble[b][c] = orderPrice[order];

                                                do {

                                                    System.out.print("¿Cuantas deseas? : ");
                                                    orderMDouble[b][c] = Double.parseDouble(in.readLine());

                                                    for (v = 9; v <= 12; v++) {
                                                        if (order == v) {
                                                            orderString[b][v] = "1";
                                                            pieces[v] = pieces[v] - orderMDouble[b][c];
                                                            if (pieces[v] < 0) {
                                                                pieces[v] = pieces[v] + orderMDouble[b][c];
                                                                // System.out.println("Sorry, We only have " + pieces[v] + "pzas. Available");
                                                                System.out.println("Lo sentimos, solamente tenemos " + pieces[v] + "pzas. Disponibles");
                                                                v = 13;
                                                                r = 1;
                                                            } else {
                                                                r = 0;
                                                            }
                                                        }
                                                    }
                                                } while (r == 1);

                                                c++;

                                                for (d = 1; d == 1;) {
                                                    // System.out.print("\nWant to Order Other DRINKS? [Y/N]: ");
                                                    System.out.print("\n¿Quieres ordenar otras BEBIDAS? [Y/N]: ");
                                                    drinksQ2 = in.readLine();

                                                    if (drinksQ2.equalsIgnoreCase("y")) {
                                                        d = 0;
                                                        c++;
                                                    } else if (drinksQ2.equalsIgnoreCase("n")) {
                                                        System.out.print("");
                                                        d = 0;
                                                        f = 0;
                                                    } else {
                                                        System.out.print("Entrada Invalida!");
                                                        d = 1;
                                                    }
                                                }
                                                if (orderString[b][9].equals("1") && orderString[b][10].equals("1") && orderString[b][11].equals("1") && orderString[b][12].equals("1")) {
                                                    // System.out.print("Sorry, You order all 4 DRINKS!");
                                                    System.out.println("Lo sentimos , usted ordeno todas las bebidas!");
                                                    drinksQ2 = "n";
                                                    f = 0;
                                                }
                                                if (pieces[9] == 0 && pieces[10] == 0 && pieces[11] == 0 && pieces[12] == 0) {
                                                    //System.out.println("\nDrinks Not Available!");
                                                    System.out.println("Bebidas no disponibles");
                                                    drinksQ2 = "n";
                                                    f = 0;
                                                }
                                            } while (drinksQ2.equalsIgnoreCase("y"));

                                        } else if (drinksQ.equalsIgnoreCase("n")) {
                                            v = 0;
                                            f = 0;
                                        } else {
                                            System.out.print("Entrada Invalida!");
                                            v = 1;
                                        }
                                    }
                                }
                                if (c == 0) {
                                    //  System.out.println("You Don't Have Any Order!");
                                    System.out.println("Usted no tiene ninguna orden!");
                                    r = 1;
                                } else {
                                    c--;
                                }
                            } while (r == 1);
                            tableNo[b] = table;
                            totalOrder[b] = c;
                            paid[b] = 0;

                            System.out.println("\n NO. Mesa:" + tableNo[b]);
                            System.out.println(" Sus ordenes son: ");
                            for (int y = 0; y <= totalOrder[b]; y++) {
                                System.out.println("   " + orderMDouble[b][y] + " pzas.\t" + orderStringM[b][y]);
                                totalPrice[b] = totalPrice[b] + (orderDouble[b][y] * orderMDouble[b][y]);
                            }
                            table++;
                            b++;
                        } //CHOICE 2 - "ORDER INFO"
                        else if (choice == 2) {

                            do {
                                System.out.print("\nNombre del consumidor: ");
                                search = in.readLine();
                                int s = 1;
                                for (int x = 0; x < b; x++) {

                                    if (search.equalsIgnoreCase(orderString[x][0])) {
                                        System.out.println(" ******   INFO DEL CONSUMIDOR  *******");
                                        System.out.println(" Nombre del consmidor: " + orderString[x][0]);
                                        System.out.println(" Número de mesa: " + tableNo[x]);
                                        System.out.println(" Orden del consumidor:");

                                        for (int y = 0; y <= totalOrder[x]; y++) {
                                            System.out.println("   " + orderMDouble[x][y] + " pzas\t" + orderStringP[x][y]);
                                        }
                                        System.out.println(" --------------------------------------");
                                        System.out.print(" Total a pagar: $" + totalPrice[x]);
                                        if (paid[x] == 1) {
                                            System.out.println(" *PAGADO*");
                                            System.out.println(" **************************************");
                                        } else {
                                            System.out.println(" *NO PAGADO*");
                                            System.out.println(" **************************************");
                                            System.out.println("\n Por favor , proceda a pagar!");
                                        }
                                        s = 0;
                                    }

                                }

                                if (s == 1) {
                                    System.out.println("Consumidor no encontrado!");
                                    g = 1;
                                } else {
                                    g = 0;
                                }

                                f = 0;
                            } while (g == 1);

                        } else if (choice == 3) {

                            do {

                                // System.out.print("\nEnter Customer Name: ");
                                System.out.print("\nIngresa nombre del consumidor: ");
                                search = in.readLine();

                                int s = 1;
                                for (int x = 0; x < b; x++) {
                                    if (search.equalsIgnoreCase(orderString[x][0])) {
                                        System.out.println(" ****   CUSTOMER ORDER RECEIPT   ****");
                                        System.out.println(" Nombre del consumidor: " + orderString[x][0]);
                                        System.out.println(" Número de mesa: " + tableNo[x]);
                                        System.out.println(" Orden del consumidor:");

                                        for (int y = 0; y <= totalOrder[x]; y++) {
                                            System.out.println("   " + orderMDouble[x][y] + " pzas\t" + orderStringP[x][y]);
                                        }
                                        System.out.println(" **************************************");
                                        System.out.print(" Total a pagar: $ " + totalPrice[x]);
                                        if (paid[x] == 1) {
                                            System.out.println(" *PAGADO*");
                                            System.out.println(" **************************************");
                                        } else {
                                            System.out.println("\n **************************************");
                                            for (int m = 1; m == 1;) {
                                                System.out.print("Ingresa la cantidad: ");
                                                payment = Double.parseDouble(in.readLine());
                                                change = payment - totalPrice[x];
                                                if (change < 0) {
                                                    m = 1;
                                                    //System.out.println("Insufficient Amount of Money! Please Try Again!");
                                                    System.out.println("Monto insuficiente , intenta de nuevo...");
                                                } else {
                                                    paid[x] = 1;
                                                    m = 0;
                                                }
                                            }
                                            System.out.println("Cambio: $" + change);
                                        }

                                        s = 0;
                                    }
                                }
                                if (s == 1) {
                                    // System.out.println("Customer Name not found!");
                                    System.out.println("Nombre del consumidor no encontrado!");
                                    h = 1;
                                } else {
                                    h = 0;
                                }
                                f = 0;

                            } while (h == 1);
                        } else if (choice == 4) {
                            System.out.println(" ********** INVENTARIO **********");
                            System.out.println(" **************************************");
                            System.out.println("\n   *********** ANTOJITOS MEXICANOS ***********");
                            System.out.println("   **********************************");
                            for (int z = 1; z <= 4; z++) {
                                System.out.println(" \t" + pieces[z] + " pzas\t\t" + orderNameM[z]);
                            }
                            System.out.println("   ************ POSTRES *************");
                            System.out.println("   **********************************");
                            for (int z = 5; z <= 8; z++) {
                                System.out.println(" \t" + pieces[z] + " pzas\t\t" + orderNameM[z]);
                            }
                            System.out.println("   ************* BEBIDAS *************");
                            System.out.println("   **********************************");
                            for (int z = 9; z <= 12; z++) {
                                System.out.println(" \t" + pieces[z] + " pzas\t\t" + orderNameM[z]);
                            }
                            System.out.println(" **************************************");
                            f = 0;
                        } else if (choice == 5) {
                            f = 0;
                            end = 1;
                            again = "n";

                            System.out.println("¡Gracias vuelva pronto!");

                        } else {
                            System.out.println("Entrada Invalida!");
                            f = 1;
                        }

                    }
                    if (end == 0) {
                        do {

                            //System.out.print("\nDo you want Another Transaction [Y/N]?");
                            System.out.println("¿Quiere hacer otra transacción? [Y/N]");
                            again = in.readLine();

                            if (again.equalsIgnoreCase("n")) {
                                i = 0;
                            } else if (again.equalsIgnoreCase("y")) {
                                i = 0;
                            } else {
                                System.out.println("Entrada Invalida!");
                                i = 1;
                            }
                        } while (i == 1);
                    }
                } while (again.equalsIgnoreCase("y"));

                break;
            } else {
                System.out.println("Usuario o Contraseña incorrectos!!");
                a++;
            }
        }

    }
}//Fin de la clase

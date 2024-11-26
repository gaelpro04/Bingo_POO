import java.util.ArrayList;

public class CartaPatrones {

    private ArrayList<Carta> cartaPatrones;

    public CartaPatrones()
    {
        cartaPatrones = new ArrayList<>(38);
        for (int i = 0;i < 38; ++i) {
            cartaPatrones.add(new Carta(true, "Patrones/patron" + i + ".png", i));
        }
        generarPatrones();
    }

    private void generarPatrones()
    {

        //Patrones 5 seguidos
        for (int i = 0; i < 12; ++i) {
            boolean[][] cartaLogica = cartaPatrones.get(i).getTablaLogica();

            if (i >= 0 && i <= 4) {
                for (int j = 0; j < 5; ++j) {
                    cartaLogica[j][i] = false;
                }
            } else if (i == 5) {
                for (int j = 0; j < 5; ++j) {
                    cartaLogica[j][j] = false;
                }
            } else if (i >= 6 && i <= 10) {
                for (int j = 0; j < 5; ++j) {
                    cartaLogica[i-6][j] = false;
                }
            } else {
                for (int j = 0; j < 5; ++j) {
                    cartaLogica[j][4 - j] = false;
                }
            }
        }

        //Patrones paquete de 6 verticales
        for (int i = 12; i < 24; ++i) {
            boolean[][] cartaLogica = cartaPatrones.get(i).getTablaLogica();

            switch (i) {
                case 12,13,14:
                    for (int j = 0; j < 5; ++j) {
                        for (int k = 0; k < 2; ++k) {
                            if (i == 12 && j < 3) {
                                cartaLogica[j][k] = false;
                            } else if (i == 13 && j < 3) {
                                cartaLogica[j+1][k] = false;
                            } else if (i == 14 && j < 3) {
                                cartaLogica[j+2][k] = false;
                            }
                        }
                        if (i == 12 && j == 2) {
                            break;
                        } else if (i == 13 && j == 2) {
                            break;
                        } else if (i == 14 && j == 2) {
                            break;
                        }
                    }
                    break;
                case 15,16,17:
                    for (int j = 0; j < 5; ++j) {
                        for (int k = 1; k < 3; ++k) {
                            if (i == 15 && j < 3) {
                                cartaLogica[j][k] = false;
                            } else if (i == 16 && j < 3) {
                                cartaLogica[j+1][k] = false;
                            } else if (i == 17 && j < 3) {
                                cartaLogica[j+2][k] = false;
                            }
                        }
                        if (i == 15 && j == 2) {
                            break;
                        } else if (i == 16 && j == 2) {
                            break;
                        } else if (i == 17 && j == 2) {
                            break;
                        }
                    }
                    break;
                case 18,19,20:
                    for (int j = 0; j < 5; ++j) {
                        for (int k = 2; k < 4; ++k) {
                            if (i == 18 && j < 3) {
                                cartaLogica[j][k] = false;
                            } else if (i == 19 && j < 3) {
                                cartaLogica[j+1][k] = false;
                            } else if (i == 20 && j < 3) {
                                cartaLogica[j+2][k] = false;
                            }
                        }
                        if (i == 18 && j == 2) {
                            break;
                        } else if (i == 19 && j == 2) {
                            break;
                        } else if (i == 20 && j == 2) {
                            break;
                        }
                    }
                    break;
                case 21,22,23:
                    for (int j = 0; j < 5; ++j) {
                        for (int k = 3; k < 5; ++k) {
                            if (i == 21 && j < 3) {
                                cartaLogica[j][k] = false;
                            } else if (i == 22 && j < 3) {
                                cartaLogica[j+1][k] = false;
                            } else if (i == 23 && j < 3) {
                                cartaLogica[j+2][k] = false;
                            }
                        }
                        if (i == 21 && j == 2) {
                            break;
                        } else if (i == 22 && j == 2) {
                            break;
                        } else if (i == 23 && j == 2) {
                            break;
                        }
                    }
                    break;
            }
        }

        //Patrones paquete de 6, horizontales
        for (int i = 24; i < 36; ++i) {
            boolean[][]cartaLogica = cartaPatrones.get(i).getTablaLogica();
            switch (i) {
                case 24,25,26:
                    for (int j = 0; j < 5; ++j) {
                        for (int k = 0; k < 2; ++k) {
                            if (i == 24 && j < 3) {
                                cartaLogica[k][j] = false;
                            } else if (i == 25 && j < 3) {
                                cartaLogica[k][j+1] = false;
                            } else if (i == 26 && j < 3) {
                                cartaLogica[k][j+2] = false;
                            }
                        }
                        if (i == 24 && j == 2) {
                            break;
                        } else if (i == 25 && j == 2) {
                            break;
                        } else if (i == 26 && j == 2) {
                            break;
                        }
                    }
                    break;
                case 27,28,29:
                    for (int j = 0; j < 5; ++j) {
                        for (int k = 1; k < 3; ++k) {
                            if (i == 27 && j < 3) {
                                cartaLogica[k][j] = false;
                            } else if (i == 28 && j < 3) {
                                cartaLogica[k][j+1] = false;
                            } else if (i == 29 && j < 3) {
                                cartaLogica[k][j+2] = false;
                            }
                        }
                        if (i == 27 && j == 2) {
                            break;
                        } else if (i == 28 && j == 2) {
                            break;
                        } else if (i == 29 && j == 2) {
                            break;
                        }
                    }
                    break;
                case 30,31,32:
                    for (int j = 0; j < 5; ++j) {
                        for (int k = 2; k < 4; ++k) {
                            if (i == 30 && j < 3) {
                                cartaLogica[k][j] = false;
                            } else if (i == 31 && j < 3) {
                                cartaLogica[k][j+1] = false;
                            } else if (i == 32 && j < 3) {
                                cartaLogica[k][j+2] = false;
                            }
                        }
                        if (i == 30 && j == 2) {
                            break;
                        } else if (i == 31 && j == 2) {
                            break;
                        } else if (i == 32 && j == 2) {
                            break;
                        }
                    }
                    break;
                case 33,34,35:
                    for (int j = 0; j < 5; ++j) {
                        for (int k = 3; k < 5; ++k) {
                            if (i == 33 && j < 3) {
                                cartaLogica[k][j] = false;
                            } else if (i == 34 && j < 3) {
                                cartaLogica[k][j+1] = false;
                            } else if (i == 35 && j < 3) {
                                cartaLogica[k][j+2] = false;
                            }
                        }
                        if (i == 33 && j == 2) {
                            break;
                        } else if (i == 34 && j == 2) {
                            break;
                        } else if (i == 35 && j == 2) {
                            break;
                        }
                    }
                    break;
            }
        }

        //Patrones especiales
        for (int i = 36; i < 38 ; ++i) {
            boolean[][] cartaLogica = cartaPatrones.get(i).getTablaLogica();

            if (i == 36) {
                cartaLogica[0][2] = false;
                cartaLogica[1][1] = false;
                cartaLogica[1][3] = false;
                cartaLogica[2][0] = false;
                cartaLogica[2][4] = false;
                cartaLogica[3][1] = false;
                cartaLogica[3][3] = false;
                cartaLogica[4][2] = false;
            } else {
                cartaLogica[1][1] = false;
                cartaLogica[1][2] = false;
                cartaLogica[1][3] = false;
                cartaLogica[2][1] = false;
                cartaLogica[2][3] = false;
                cartaLogica[3][1] = false;
                cartaLogica[3][2] = false;
                cartaLogica[3][3] = false;

            }

        }
    }

    public void mostrarPatron()
    {
        cartaPatrones.forEach(Carta::mostrarCartaLogica);
    }

    public ArrayList<Carta> getCartaPatrones()
    {
        return cartaPatrones;
    }

    public int obtenerCantidadFalse(int indice)
    {
        boolean[][] cartaPatron = cartaPatrones.get(indice).getTablaLogica();
        int cantidadElementosFalse = 0;
        for (int i = 0;i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (!cartaPatron[i][j]) {
                    ++cantidadElementosFalse;
                }
            }
        }
        return cantidadElementosFalse;
    }



    public static void mai1n(String[] args) {

        new CartaPatrones().mostrarPatron();
    }
}

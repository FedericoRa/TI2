package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import exceptions.CountryDoesNotExist;
import model.City;
import model.Country;

import java.util.ArrayList;



public class GeoController {

    private ArrayList<Country> country;
    private ArrayList<City> city;

    public GeoController() {
        country = new ArrayList<>();
        city = new ArrayList<>();
    }

    public void importText() {
        System.out.println("por favor minimiza la venta del editor, para seleccionar el archivo");
        JFileChooser fileChoser = new JFileChooser();
        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("CSV", "csv");
        fileChoser.setFileFilter(filtrado);
        fileChoser.setDialogTitle("Selecciona el archivo");
        int returnValue = fileChoser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChoser.getSelectedFile();
            // automaton.Import(selectedFile.getAbsolutePath());


        } else {

        }

    }


    public void insertConsult(String[] partsConsult, String consult) {
        String where = "where";
        String from = "from";
        String sign = "*";
        if (partsConsult[3].equals("cities")) {
            if (sign.equals(partsConsult[1]) && from.equalsIgnoreCase(partsConsult[2])) {
                if (partsConsult.length > 4) {
                    if (where.equalsIgnoreCase(partsConsult[4])) {
                        if (partsConsult[6].equals("=")) {
                            consultEqualsCities(partsConsult, consult);

                        } else if (partsConsult[6].equals(">")) {

                            consultMajorCities(partsConsult, consult);
                        } else if (partsConsult[6].equals("<")) {
                            consultMinorCities(partsConsult, consult);
                        }
                    }
                } else {
                    for (int i = 0; i < city.size(); i++) {
                        System.out.println(city.get(i).information());
                    }
                }
            } else {
                System.out.println("Debe acomodar la estructura de la consulta");
            }

        } else if (partsConsult[3].equals("countries")) {

            if (sign.equals(partsConsult[1]) && from.equalsIgnoreCase(partsConsult[2])) {
                if (partsConsult.length > 4) {
                    if (where.equalsIgnoreCase(partsConsult[4])) {
                        if (partsConsult[6].equals("=")) {
                            consultEqualsCountry(partsConsult, consult);

                        } else if (partsConsult[6].equals(">")) {

                            consultMajorCountry(partsConsult, consult);
                        } else if (partsConsult[6].equals("<")) {
                            consultMinorCountry(partsConsult, consult);
                        }
                    }
                } else {
                    for (int i = 0; i < country.size(); i++) {
                        System.out.println(country.get(i).information());
                    }
                }
            } else {
                System.out.println("Debe acomodar la estructura de la consulta");
            }

        } else {
            System.out.println("la consulta no es valida  ");
        }

    }

    public void consultMinorCountry(String[] partsConsult, String consult) {
        String name = "name";
        String id = "id";
        String countryCode = "countrycode";
        String population = "population";
        String order = "order";
        String by = "by";
        consult = consult.replace("'", "");
        partsConsult = consult.split(" ");
        if (partsConsult.length > 10) {
            if (order.equalsIgnoreCase(partsConsult[8]) && by.equalsIgnoreCase(partsConsult[9])) {
                if (name.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(country, new Comparator<Country>() {
                        public int compare(Country p1, Country p2) {
                            return new String(p1.getName()).compareTo(new String(p2.getName()));
                        }
                    });

                } else if (id.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(country, new Comparator<Country>() {
                        public int compare(Country p1, Country p2) {
                            return new String(p1.getId()).compareTo(new String(p2.getId()));
                        }
                    });
                } else if (countryCode.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(country, new Comparator<Country>() {
                        public int compare(Country p1, Country p2) {
                            return new String(p1.getCountryCode()).compareTo(new String(p2.getCountryCode()));
                        }
                    });
                } else if (population.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(country);
                }
            }
        }
        double value = Double.parseDouble(partsConsult[7]);
        if (population.equalsIgnoreCase(partsConsult[5])) {
            for (int i = 0; i < country.size(); i++) {
                if (value > country.get(i).getPopulation()) {
                    System.out.println(country.get(i).information());
                }
            }
        } else {
            System.out.println("No puede aplicar esta operacion a esa columna");
        }

    }

    public void consultMajorCountry(String[] partsConsult, String consult) {
        String name = "name";
        String id = "id";
        String countryCode = "countrycode";
        String population = "population";
        String order = "order";
        String by = "by";
        consult = consult.replace("'", "");
        partsConsult = consult.split(" ");
        if (partsConsult.length > 10) {
            if (order.equalsIgnoreCase(partsConsult[8]) && by.equalsIgnoreCase(partsConsult[9])) {
                if (name.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(country, new Comparator<Country>() {
                        public int compare(Country p1, Country p2) {
                            return new String(p1.getName()).compareTo(new String(p2.getName()));
                        }
                    });

                } else if (id.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(country, new Comparator<Country>() {
                        public int compare(Country p1, Country p2) {
                            return new String(p1.getId()).compareTo(new String(p2.getId()));
                        }
                    });
                } else if (countryCode.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(country, new Comparator<Country>() {
                        public int compare(Country p1, Country p2) {
                            return new String(p1.getCountryCode()).compareTo(new String(p2.getCountryCode()));
                        }
                    });
                } else if (population.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(country);
                }
            }
        }
        double value = Double.parseDouble(partsConsult[7]);
        if (population.equalsIgnoreCase(partsConsult[5])) {
            for (int i = 0; i < country.size(); i++) {
                if (value < country.get(i).getPopulation()) {
                    System.out.println(country.get(i).information());
                }
            }
        } else {
            System.out.println("No puede aplicar esta operacion a esa columna");
        }

    }

    public void consultEqualsCountry(String[] partsConsult, String consult) {
        String name = "name";
        String id = "id";
        String countryCode = "countrycode";
        String population = "population";
        consult = consult.replace("'", "");
        partsConsult = consult.split(" ");
        String order = "order";
        String by = "by";
        if (partsConsult.length > 10) {
            if (order.equalsIgnoreCase(partsConsult[8]) && by.equalsIgnoreCase(partsConsult[9])) {
                if (name.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(country, new Comparator<Country>() {
                        public int compare(Country p1, Country p2) {
                            return new String(p1.getName()).compareTo(new String(p2.getName()));
                        }
                    });

                } else if (id.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(country, new Comparator<Country>() {
                        public int compare(Country p1, Country p2) {
                            return new String(p1.getId()).compareTo(new String(p2.getId()));
                        }
                    });
                } else if (countryCode.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(country, new Comparator<Country>() {
                        public int compare(Country p1, Country p2) {
                            return new String(p1.getCountryCode()).compareTo(new String(p2.getCountryCode()));
                        }
                    });
                } else if (population.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(country);
                }
            }
        }
        for (int i = 0; i < country.size(); i++) {
            if (name.equalsIgnoreCase(partsConsult[5])) {
                if (partsConsult[7].equals(country.get(i).getName())) {
                    System.out.println(country.get(i).information());
                }
            } else if (id.equalsIgnoreCase(partsConsult[5])) {
                if (partsConsult[7].equals(country.get(i).getId())) {
                    System.out.println(country.get(i).information());
                }
            } else if (countryCode.equalsIgnoreCase(partsConsult[5])) {
                if (partsConsult[7].equals(country.get(i).getCountryCode())) {
                    System.out.println(country.get(i).information());
                }
            } else if (population.equalsIgnoreCase(partsConsult[5])) {
                double value = Double.parseDouble(partsConsult[7]);
                if (value == country.get(i).getPopulation()) {
                    System.out.println(country.get(i).information());
                }
            }
        }

    }

    public void consultMinorCities(String[] partsConsult, String consult) {
        String order = "order";
        String by = "by";
        String name = "name";
        String id = "id";
        String countryID = "countryid";
        String population = "population";
        consult = consult.replace("'", "");
        partsConsult = consult.split(" ");
        if (partsConsult.length > 10) {
            if (order.equalsIgnoreCase(partsConsult[8]) && by.equalsIgnoreCase(partsConsult[9])) {
                if (name.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(city, new Comparator<City>() {
                        public int compare(City p1, City p2) {
                            return new String(p1.getName()).compareTo(new String(p2.getName()));
                        }
                    });

                } else if (id.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(city, new Comparator<City>() {
                        public int compare(City p1, City p2) {
                            return new String(p1.getId()).compareTo(new String(p2.getId()));
                        }
                    });
                } else if (countryID.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(city, new Comparator<City>() {
                        public int compare(City p1, City p2) {
                            return new String(p1.getCountryId()).compareTo(new String(p2.getCountryId()));
                        }
                    });
                } else if (population.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(city);
                }
            }
        }
        double value = Double.parseDouble(partsConsult[7]);
        if (population.equalsIgnoreCase(partsConsult[5])) {
            for (int i = 0; i < city.size(); i++) {
                if (value > city.get(i).getPopulation()) {
                    System.out.println(city.get(i).information());
                }
            }
        } else {
            System.out.println("No puede aplicar esta operacion a esa columna");
        }
    }

    public void consultMajorCities(String[] partsConsult, String consult) {
        String order = "order";
        String by = "by";
        String name = "name";
        String id = "id";
        String countryID = "countryid";
        String population = "population";
        consult = consult.replace("'", "");
        partsConsult = consult.split(" ");
        if (partsConsult.length > 10) {
            if (order.equalsIgnoreCase(partsConsult[8]) && by.equalsIgnoreCase(partsConsult[9])) {
                if (name.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(city, new Comparator<City>() {
                        public int compare(City p1, City p2) {
                            return new String(p1.getName()).compareTo(new String(p2.getName()));
                        }
                    });

                } else if (id.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(city, new Comparator<City>() {
                        public int compare(City p1, City p2) {
                            return new String(p1.getId()).compareTo(new String(p2.getId()));
                        }
                    });
                } else if (countryID.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(city, new Comparator<City>() {
                        public int compare(City p1, City p2) {
                            return new String(p1.getCountryId()).compareTo(new String(p2.getCountryId()));
                        }
                    });
                } else if (population.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(city);
                }
            }
        }
        double value = Double.parseDouble(partsConsult[7]);
        if (population.equalsIgnoreCase(partsConsult[5])) {
            for (int i = 0; i < city.size(); i++) {
                if (value < city.get(i).getPopulation()) {
                    System.out.println(city.get(i).information());
                }
            }
        } else {
            System.out.println("No puede aplicar esta operacion a esa columna");
        }
    }

    public void consultEqualsCities(String[] partsConsult, String consult) {
        String name = "name";
        String id = "id";
        String countryID = "countryid";
        String population = "population";
        consult = consult.replace("'", "");
        partsConsult = consult.split(" ");
        String order = "order";
        String by = "by";
        if (partsConsult.length > 10) {
            if (order.equalsIgnoreCase(partsConsult[8]) && by.equalsIgnoreCase(partsConsult[9])) {
                if (name.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(city, new Comparator<City>() {
                        public int compare(City p1, City p2) {
                            return new String(p1.getName()).compareTo(new String(p2.getName()));
                        }
                    });

                } else if (id.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(city, new Comparator<City>() {
                        public int compare(City p1, City p2) {
                            return new String(p1.getId()).compareTo(new String(p2.getId()));
                        }
                    });
                } else if (countryID.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(city, new Comparator<City>() {
                        public int compare(City p1, City p2) {
                            return new String(p1.getCountryId()).compareTo(new String(p2.getCountryId()));
                        }
                    });
                } else if (population.equalsIgnoreCase(partsConsult[10])) {
                    Collections.sort(city);
                }
            }
        }
        for (int i = 0; i < city.size(); i++) {
            if (name.equalsIgnoreCase(partsConsult[5])) {
                if (partsConsult[7].equals(city.get(i).getName())) {
                    System.out.println(city.get(i).information());
                }
            } else if (id.equalsIgnoreCase(partsConsult[5])) {
                if (partsConsult[7].equals(city.get(i).getId())) {
                    System.out.println(city.get(i).information());
                }
            } else if (countryID.equalsIgnoreCase(partsConsult[5])) {
                if (partsConsult[7].equals(city.get(i).getCountryId())) {
                    System.out.println(city.get(i).information());
                }
            } else if (population.equalsIgnoreCase(partsConsult[5])) {
                double value = Double.parseDouble(partsConsult[7]);
                if (value == city.get(i).getPopulation()) {
                    System.out.println(city.get(i).information());
                }
            }
        }

    }

    public void insertFuntion(String[] partsConsult, String consult) throws CountryDoesNotExist {
        boolean correctComand = false;
        partsConsult = consult.split(" values ");
        if (partsConsult.length > 1) {
            if (partsConsult[0].equalsIgnoreCase("INSERT INTO countries(id, name, population, countryCode)")
                    || partsConsult[0].equalsIgnoreCase("INSERT INTO cities(id, name, countryID, population)")) {
                correctComand = true;
            }
        } else {
            partsConsult = consult.split(" VALUES ");
            if (partsConsult.length > 1) {
                if (partsConsult[0].equalsIgnoreCase("INSERT INTO countries(id, name, population, countryCode)")
                        || partsConsult[0].equalsIgnoreCase("INSERT INTO cities(id, name, countryID, population)")) {
                    correctComand = true;
                }
            } else {
                System.out.println("La operacion que intenta hacer no es valida");
            }
        }
        if (correctComand == true) {
            if (partsConsult[0].contains("countries")) {
                String dentroParent = partsConsult[1].substring(partsConsult[1].indexOf("(") + 1,
                        partsConsult[1].indexOf(")"));
                dentroParent = dentroParent.replace("'", "").replace(" ", "");
                String[] partsCountry = dentroParent.split(",");
                double value = Double.parseDouble(partsCountry[2]);
                Country countryInsert = new Country(partsCountry[0], partsCountry[1], value, partsCountry[3]);
                country.add(countryInsert);
            }
            if (partsConsult[0].contains("cities")) {
                String dentroParent = partsConsult[1].substring(partsConsult[1].indexOf("(") + 1,
                        partsConsult[1].indexOf(")"));
                dentroParent = dentroParent.replace("'", "").replace(" ", "");
                String[] partsCity = dentroParent.split(",");

                double value = Double.parseDouble(partsCity[3]);
                boolean notFound = true;
                for (int i = 0; i < country.size() && notFound; i++) {
                    if (country.get(i).getId().equalsIgnoreCase(partsCity[2])) {
                        notFound = false;
                    }
                }
                if (notFound == true) {
                    throw new CountryDoesNotExist("ERROR EL PAIS NO EXISTE");
                } else {
                    City cityInsert = new City(partsCity[0], partsCity[1], partsCity[2], value);
                    city.add(cityInsert);
                }
            }
        }

    }

}

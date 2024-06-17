   
# CompareMethod
```java
    // Sort countries by total medals count
    Collections.sort(countries, new Comparator<Country>() {
    @Override
    public int compare(Country c1, Country c2) {
    return Integer.compare(c1.getTotalMedals(), c2.getTotalMedals());
    }
    });

    // Write each country and its total medals count
    for (Country country : countries) {
    bw.write(country.getName() + ", Anzahl der Medaillen: " + country.getTotalMedals() + "\n");
    }
```
# Lambda Expression
```java
    Collections.sort(countries, Comparator.comparingInt(Country::getTotalMedals));

    // Write each country and its total medals count
    for (Country country : countries) {
    bw.write(country.getName() + ", Anzahl der Medaillen: " + country.getTotalMedals() + "\n");
    }
```
# Java Streams
```java
    // Sort countries by total medals count using Stream API
    List<Country> sortedCountries = countries.stream()
    .sorted(Comparator.comparingInt(Country::getTotalMedals))
    .collect(Collectors.toList());

    // Write each country and its total medals count
    for (Country country : sortedCountries) {
    bw.write(country.getName() + ", Anzahl der Medaillen: " + country.getTotalMedals() + "\n");
    }    
```
# Manual Sorting
````java
            // Manual sorting of countries by total medals count
            for (int i = 0; i < countries.size() - 1; i++) {
                for (int j = i + 1; j < countries.size(); j++) {
                    if (countries.get(i).getTotalMedals() > countries.get(j).getTotalMedals()) {
                        Country temp = countries.get(i);
                        countries.set(i, countries.get(j));
                        countries.set(j, temp);
                    }
                }
            }

            // Write each country and its total medals count
            for (Country country : countries) {
                bw.write(country.getName() + ", Anzahl der Medaillen: " + country.getTotalMedals() + "\n");
            }
````
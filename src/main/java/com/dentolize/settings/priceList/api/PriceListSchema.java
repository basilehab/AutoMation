package com.dentolize.settings.priceList.api;

public class PriceListSchema {
    private static PriceListSchema priceListInstance;

    private PriceListSchema() {
        // Private constructor to prevent instantiation
    }

    public static synchronized PriceListSchema getInstance() {
        if (priceListInstance == null) {
            priceListInstance = new PriceListSchema();
        }
        return priceListInstance;
    }

    public final String QUERY_SEARCH_PRICE_LISTS = """
            query SEARCH_PRICE_LISTS_QUERY($searchTerm: String!) {
              searchPriceLists(searchTerm: $searchTerm) {
                id
                name
                syncTo
                percentage
                difference
                __typename
              }
            }
            """;

    public final String MUTATION_ADD_PRICE_LIST = """
            mutation ADD_PRICE_LIST($name: String!, $syncTo: ID, $percentage: Int, $difference: Int, $keepInSync: Boolean, $branches: [ID!]!) {
              addNewPriceList(
                name: $name
                syncTo: $syncTo
                percentage: $percentage
                difference: $difference
                keepInSync: $keepInSync
                branches: $branches
              ) {
                id
                name
                syncTo
                percentage
                difference
                branches {
                  id
                  name
                  __typename
                }
                __typename
              }
            }
            """;

    public final String MUTATION_EDIT_PRICE_LISTS = """
            mutation EDIT_PRICE_LISTS($name: String!, $priceList: ID!, $percentage: Int, $difference: Int, $branches: [ID!]!) {
              editPriceList(
                name: $name
                priceList: $priceList
                percentage: $percentage
                difference: $difference
                branches: $branches
              ) {
                id
                name
                syncTo
                percentage
                difference
                branches {
                  id
                  name
                  __typename
                }
                updatedBy {
                  id
                  name
                  __typename
                }
                __typename
              }
            }
            """;

    public final String MUTATION_DELETE_PRICE_LISTS = """
            mutation DELETE_PRICE_LISTS($priceList: ID!) {
              deletePriceList(priceList: $priceList) {
                id
                __typename
              }
            }
            """;
}
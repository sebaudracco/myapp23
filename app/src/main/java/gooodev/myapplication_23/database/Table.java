package gooodev.myapplication_23.database;


public class Table
{
    public static class Category
    {
        public static final String CATEGORY_TYPE = "category_type";
        public static final String CAT_ID = "cat_id";
        public static final String CREATE_CATEGORY_TABLES = " CREATE TABLE category_type(cat_id INTEGER PRIMARY KEY AUTOINCREMENT, category_type TEXT )";
        public static final String TABLE_NAME = "category_type";
    }

    public static class City
    {
        public static final String CITY_ID = "city_id";
        public static final String CITY_NAME = "city_name";
        public static final String COUNTRY_ID = "country_id";
        public static final String CREATE_CITY_TABLES = " CREATE TABLE city(city_id INTEGER PRIMARY KEY AUTOINCREMENT, country_id TEXT, state_id TEXT, city_name TEXT )";
        public static final String STATE_ID = "state_id";
        public static final String TABLE_NAME = "city";
    }

    public static class Contact
    {
        public static final String ADDRESS = "address";
        public static final String CATEGORY_TYPE = "category_type";
        public static final String CITY = "city";
        public static final String COMPANY_NAME = "company_name";
        public static final String COUNTRY = "country";
        public static final String CREATE_CONTACT_DETAILS_TABLES = " CREATE TABLE contact_details(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT, photo_url TEXT, mobile TEXT, landline TEXT, address TEXT, state TEXT, country TEXT, city TEXT, company_name TEXT, category_type TEXT, website TEXT )";
        public static final String EMAIL = "email";
        public static final String LANDLINE = "landline";
        public static final String MOBILE = "mobile";
        public static final String NAME = "name";
        public static final String PHOTO_URl = "photo_url";
        public static final String STATE = "state";
        public static final String TABLE_NAME = "contact_details";
        public static final String WEBSITE = "website";
        public static final String _ID = "_id";
    }

    public static class Country
    {
        public static final String COUNTRY_ID = "country_id";
        public static final String COUNTRY_NAME = "country_name";
        public static final String CREATE_COUNTRY_TABLES = " CREATE TABLE country(country_id INTEGER PRIMARY KEY AUTOINCREMENT, country_name TEXT )";
        public static final String TABLE_NAME = "country";
    }

    public static class State
    {
        public static final String COUNTRY_ID = "country_id";
        public static final String CREATE_STATE_TABLES = " CREATE TABLE state(state_id INTEGER PRIMARY KEY AUTOINCREMENT, country_id TEXT, state_name TEXT )";
        public static final String STATE_ID = "state_id";
        public static final String STATE_NAME = "state_name";
        public static final String TABLE_NAME = "state";
    }
}

// 200 response test
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

//200 response test
pm.test("Status code is 200", () => {
    pm.expect(pm.response.code).to.eql(200);
});

//multiple assertions
pm.test("The response has all properties", () => {
    //parse the response JSON and test three properties
    const responseJson = pm.response.json();
    pm.expect(responseJson.type).to.eql('vip');
    pm.expect(responseJson.name).to.be.a('string');
    pm.expect(responseJson.id).to.have.lengthOf(1);
});

//Parse JSON
const responseJson = pm.response.json();

//Parse XML
const responseJson = xml2Json(pm.response.text());

//Parse CSV (CSV Parse)
const parse = require('csv-parse/lib/sync');
const responseJson = parse(pm.response.text())

//Parse HTML (CHEERIO)
const $ = cheerio.load(pm.response.text());
//output the html for testing
console.log($.html());

//Parse  STRING
pm.test("Body contains string",() => {
    pm.expect(pm.response.text()).to.include("customer_id");
});

//Response matches String
pm.test("Body is string", function () {
    pm.response.to.have.body("whole-body-text");
});

//Testing response body
pm.test("Person is Jane", () => {
    const responseJson = pm.response.json();
    pm.expect(responseJson.name).to.eql("Jane");
    pm.expect(responseJson.age).to.eql(23);
});

//Testing status codes
pm.test("Status code is 201", () => {
    pm.response.to.have.status(201);
});

//Testing status codes  (one of a set)
pm.test("Successful POST request", () => {
    pm.expect(pm.response.code).to.be.oneOf([201,202]);
});

//Check the status code text
pm.test("Status code name has string", () => {
    pm.response.to.have.status("Created");
});

//Testing headers

//Check that a response header is present:
pm.test("Content-Type header is present", () => {
    pm.response.to.have.header("Content-Type");
});

//Test for a response header having a particular value:
pm.test("Content-Type header is application/json", () => {
    pm.expect(pm.response.headers.get('Content-Type')).to.eql('application/json');
});

//Testing cookies

//Test if a cookie is present in the response
pm.test("Cookie JSESSIONID is present", () => {
    pm.expect(pm.cookies.has('JSESSIONID')).to.be.true;
});

//Test for a particular cookie value:
pm.test("Cookie isLoggedIn has value 1", () => {
    pm.expect(pm.cookies.get('isLoggedIn')).to.eql('1');
});

//Testing response times

//Test for the response time to be within a specified range:
pm.test("Response time is less than 200ms", () => {
    pm.expect(pm.response.responseTime).to.be.below(200);
});

//Common assertion examples

//Asserting a response value against a variable
pm.test("Response property matches environment variable", function () {
    pm.expect(pm.response.json().name).to.eql(pm.environment.get("name"));
});

//Asserting a value type

//Test the type of any part of the response:

/* response has this structure:
{
  "name": "Jane",
  "age": 29,
  "hobbies": [
    "skating",
    "painting"
  ],
  "email": null
}
*/
const jsonData = pm.response.json();
pm.test("Test data type of the response", () => {
    pm.expect(jsonData).to.be.an("object");
    pm.expect(jsonData.name).to.be.a("string");
    pm.expect(jsonData.age).to.be.a("number");
    pm.expect(jsonData.hobbies).to.be.an("array");
    pm.expect(jsonData.website).to.be.undefined;
    pm.expect(jsonData.email).to.be.null;
});

// Asserting array properties

//Check if an array is empty, and if it contains particular items:

/*
response has this structure:
{
    "errors": [],
    "areas": [ "goods", "services" ],
    "settings": [
    {
        "type": "notification",
        "detail": [ "email", "sms" ]
    },
    {
        "type": "visual",
        "detail": [ "light", "large" ]
    }
]
}
*/

const jsonData = pm.response.json();
pm.test("Test array properties", () => {
    //errors array is empty
    pm.expect(jsonData.errors).to.be.empty;
    //areas includes "goods"
    pm.expect(jsonData.areas).to.include("goods");
    //get the notification settings object
    const notificationSettings = jsonData.settings.find
    (m => m.type === "notification");
    pm.expect(notificationSettings)
        .to.be.an("object", "Could not find the setting");
    //detail array must include "sms"
    pm.expect(notificationSettings.detail).to.include("sms");
    //detail array must include all listed
    pm.expect(notificationSettings.detail)
        .to.have.members(["email", "sms"]);
});

//Asserting object properties

//Assert that an object contains keys or properties:

pm.expect({a: 1, b: 2}).to.have.all.keys('a', 'b');
pm.expect({a: 1, b: 2}).to.have.any.keys('a', 'b');
pm.expect({a: 1, b: 2}).to.not.have.any.keys('c', 'd');
pm.expect({a: 1}).to.have.property('a');
pm.expect({a: 1, b: 2}).to.be.an('object')
    .that.has.all.keys('a', 'b');

// Asserting that a value is in a set
// Check a response value against a list of valid options:
pm.test("Value is in valid list", () => {
    pm.expect(pm.response.json().type)
        .to.be.oneOf(["Subscriber", "Customer", "User"]);
});

//Asserting that an object is contained

//Check that an object is part of a parent object:

/*
response has the following structure:
{
  "id": "d8893057-3e91-4cdd-a36f-a0af460b6373",
  "created": true,
  "errors": []
}
*/

pm.test("Object is contained", () => {
    const expectedObject = {
        "created": true,
        "errors": []
    };
    pm.expect(pm.response.json()).to.deep.include(expectedObject);
});

//Asserting the current environment
//Check the active (currently selected) environment in Postman:

pm.test("Check the active environment", () => {
    pm.expect(pm.environment.name).to.eql("Production");
});

//Troubleshooting common test errors

//Log the value of a variable or response property:
console.log(pm.collectionVariables.get("name"));
console.log(pm.response.json().name);

//Log the type of a variable or response property:
console.log(typeof pm.response.json().id);

//Use console logs to mark code execution, sometimes known as "trace statements":
if (pm.response.json().id) {
    console.log("id was found!");
    // do something
} else {
    console.log("no id ...");
    //do something else
}

//Assertion deep equality error
pm.expect(1).to.eql("1");

//JSON not defined error
pm.test("Test 1", () => {
    const jsonData = pm.response.json();
    pm.expect(jsonData.name).to.eql("John");
});

pm.test("Test 2", () => {
    pm.expect(jsonData.age).to.eql(29); // jsonData is not defined
});

//Assertion undefined error
pm.expect(jsonData.name).to.eql("John");

//Test not failing
//test function not properly defined - missing second parameter
pm.test("Not failing", function () {
    pm.expect(true).to.eql(false);
});


//Validating response structure

//Carry out JSON schema validation with Tiny Validator V4 (tv4):

const schema = {
    "items": {
        "type": "boolean"
    }
};
const data1 = [true, false];
const data2 = [true, 123];

pm.test('Schema is valid', function() {
    pm.expect(tv4.validate(data1, schema)).to.be.true;
    pm.expect(tv4.validate(data2, schema)).to.be.true;
});

//Validate JSON schema with the Ajv JSON schema validator:
const schema = {
    "properties": {
        "alpha": {
            "type": "boolean"
        }
    }
};
pm.test('Schema is valid', function() {
    pm.response.to.have.jsonSchema(schema);
});

//Sending an asynchronous request

//Send a request from your test code and log the response.
pm.sendRequest("https://postman-echo.com/get", function (err, response) {
    console.log(response.json());
});


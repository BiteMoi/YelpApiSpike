Quickstart
==========

Follow the instructions in src/test/resources/yelp.properties.example
to obtain access to the Yelp API and then run the YelpApiSpikeIntegrationTest.

Details
=======

The Yelp API (version 2, which we should probably aim to use) uses OAuth 1 for
authentication so the spike makes use of a library called Scribe which supports
making requests against an OAuth enabled REST service.

I'm loading the properties from a file since that way we can each have our own
API keys and don't have to commit anything secret to GitHub.

The implementation has a proxy, YelpProxy which can make requests against Yelp
and a couple of wire types, SearchWireType and BusinessWireType which represent the
data we care about in the test from the response. The test just performs a search 
and checks that there are some results.

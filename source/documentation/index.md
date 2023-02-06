---
title: CTC Traders phase 5 service guide
weight: 1
description: Software developers, designers, product owners or business analysts. Integrate your software with Common Transit Convention Traders API.
---

# CTC Traders API phase 5 service guide

Learn how to use [CTC Traders API v2.0](/api-documentation/docs/api/service/common-transit-convention-traders/2.0) with your software.

## API overview

The CTC Traders API is based on REST principles with endpoints that return data in JSON format and it uses standard HTTP error response codes.

Use the CTC Traders API to:

- send departure and arrival movement notifications to the New Computerised Transit System (NCTS)
- retrieve messages sent from customs offices of departure and destination

The API endpoints relate only to Great Britain and Northern Ireland. You can also use the HMRC sandbox environment to run tests for Great Britain and Northern Ireland transit movements.

## API status

This version of the CTC Traders API supports only NCTS phase 5. [CTC Traders API v1.0](/api-documentation/docs/api/service/common-transit-convention-traders/1.0) supports only NCTS phase 4.

## Related documentation

- [CTC Traders API roadmap](/roadmaps/common-transit-convention-traders-roadmap/#phase-5)

- [CTC Traders API v2.0 reference](api-documentation/docs/api/service/common-transit-convention-traders/2.0/oas/page)
- [NCTS Phase 5 Technical Interface Specification](/guides/ctc-traders-phase5-tis)

## Getting started

These steps must be followed before you can use your software in the live environment and access our live API:

1. **Subscribe** to the Developer Hub by [registering for a developer account](/developer/registration).
1. **Create** an application by following the instructions on [Using the Developer Hub](/api-documentation/docs/using-the-hub).
1. **Subscribe** to the CTC Traders API (V2.0 Beta) and to the Test User API using your test application.
1. **Read** about the [Government Gateway Authorisation](/api-documentation/docs/authorisation). Before you can access the CTC Traders API, your software needs to authenticate using OAuth 2.0.
1. **Read** guidance on the [OAuth 2.0](/api-documentation/docs/authorisation) standards required for all of HMRC’s APIs.
1. **Create** [test users](/api-documentation/docs/api/service/api-platform-test-user/1.0) before you can test your application.
1. **Download** reference data to get Customs Offices List (COL) data to use for testing. Visit the [EU’s reference data download page](https://ec.europa.eu/taxation_customs/dds2/rd/rd_download_home.jsp?Lang=en) to download reference data.
1. **Test** your application in the sandbox environment by following the steps in our Guide to Testing (**currently unavailable**).
1. **Complete** the Application for Productions Checklist form (**currently unavailable**).
1. **Apply** for production credentials through your [developer account](/developer/login) before you go live.
1. **Get your customers ready** by asking them to apply for an [EORI number](https://www.gov.uk/eori) and a [Government Gateway account](https://www.gov.uk/log-in-register-hmrc-online-services).

## Get your customers ready

Your customers need to [sign up to the CTC Traders API](https://www.tax.service.gov.uk/customs-enrolment-services/ctc/subscribe) and provide you with the following details:

* GB Economic Operators Registration and Identification (EORI) number
* VAT details (optional) 
* Standard Industrial Classification (SIC) code
* company or organisation details: 
  * unique tax reference (UTR) number 
  * registered company name (this must be an exact match)
  * registered company address 
  * date of company establishment 

They will also need to provide:

* email address 
* contact details

## Percent-encoding of parameters in request URLs

When writing code to use date filters in request URLs, you must always use percent-encoding to avoid getting 400 Bad Request errors. This is because some common characters used in dates and timestamps cannot be used in URLs.

### Format

When formatting query parameters into a request URL for date and time filtering functionality, you must use only the [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) standard for the date and time. For example, the timestamp `2021-06-21T09:00+00:00` should be encoded as `2021-06-21T09%3A00%2B00%3A00`. For more information about this, see our [Reference guide](/api-documentation/docs/reference-guide#common-data-types).

You should also note the following:

 - some common data types described in our [Reference guide](/api-documentation/docs/reference-guide#common-data-types) contain characters that are not valid for use in URLs
 - some software libraries and frameworks do percent-encoding for you automatically

### Examples

Below are examples in different programming languages.

#### Java

```java
java.net.URLEncoder.encode("2021-04-30T16:08:31+00:00");
```

#### Python

```python
from urllib.parse import quote

quote('2021-04-30T16:08:31+00:00')
```

#### C# #

```c#
Uri.EscapeDataString("2021-04-30T16:08:31+00:00");
```

### Find out more

For background information about percent-encoding, we recommend the following:

 - [RFC](https://datatracker.ietf.org/doc/html/rfc3986)
 - [Wikipedia](https://en.wikipedia.org/wiki/Percent-encoding)
 - [MDN](https://developer.mozilla.org/en-US/docs/Glossary/percent-encoding)

## Push-pull notifications

You can use our Push-Pull-Notification Service (PPNS) to receive notifications of new messages from the NCTS as follows:

* if your endpoint is hosted by Amazon Web Services (AWS), you must use either [edge-optimised custom domain names](https://docs.aws.amazon.com/apigateway/latest/developerguide/how-to-edge-optimized-custom-domain-name.html) or [regional custom domain names](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-regional-api-custom-domain-create.html)
* you will receive a push notification each time when there is a new message for you to read
* for messages less than 100KB, a push notification will contain the message body
* a push notification will have a field containing the message URI
* you can use this URI to download the XML message from the CTC Traders API

Using this functionality means that you can avoid polling for new messages and thus save time and resources.

## Process flows

Process flows are available in the [NCTS Phase 5 Technical Interface Specification](/guides/ctc-traders-phase5-tis).

## NCTS message details

### XSD - XML schema Definition
The API uses XSD templates to validate all the Information Exchange (IE) messages that come into the system.

If there are any problems, the IE message will be rejected with a 400 BadRequest status which will contain an explanation of the problem.

The XML schemas are available for download [here](https://github.com/hmrc/transit-movements-validator/tree/main/conf/xsd).

### Information exchange messages

These are standard messages sent to and received from NCTS. For details, see the [NCTS Phase 5 Technical Interface Specification](/guides/ctc-traders-phase5-tis).

## API features

### Rate limits

Our API Platform’s standard rate limit is [3 requests per second](/api-documentation/docs/reference-guide#rate-limiting). If you need a higher rate limit, you must give us more information about data and limit forecasts when filling in the Application for Production Credentials checklist form (**currently unavailable**).

## Get support

Before you get in touch, find out if there are any planned API downtime or technical issues by checking:

 - [HMRC API Platform availability](https://api-platform-status.production.tax.service.gov.uk/)
 - [NCTS service availability](https://www.gov.uk/government/publications/new-computerised-transit-system-ncts-web-service-availability-and-issues/new-computerised-transit-system-ncts-web-service-availability-and-issues)

If you have specific questions about the CTC Traders API, get in touch with our Software Developer Support Team.

You’ll get an initial response in 2 working days.

Email us your questions to [SDSTeam@hmrc.gov.uk](mailto:SDSTeam@hmrc.gov.uk). We might ask for more detailed information when we respond.

## Changelog

You can find the changelog in the [ctc-traders-phase5-service-guide](https://github.com/hmrc/ctc-traders-phase5-service-guide/wiki/CTC-Traders-API-phase-5-service-guide-changelog) GitHub wiki.

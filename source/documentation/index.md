---
title: CTC Traders API phase 5 service guide
weight: 1
description: Software developers, designers, product owners or business analysts. Send departure and arrival movement notifications to the NCTS.
---

# CTC Traders API phase 5 service guide

Learn how to use [CTC Traders API v2.0](/api-documentation/docs/api/service/common-transit-convention-traders/2.0) with your software.

[Learn about key NCTS5 dates](/guides/ctc-traders-phase5-tis/#ncts5-key-dates).

## API overview

The CTC Traders API is based on REST principles with endpoints that return data in JSON format and it uses standard HTTP error response codes.

Use the API to:

- send departure and arrival movement notifications to the New Computerised Transit System (NCTS)
- retrieve messages sent from customs offices of departure and destination

You can use this version of the API to send both small (up to 5MB in size) and large (up to 8MB in size) messages. The large messages capability applies only to POST endpoints.

The API endpoints relate only to Great Britain and Northern Ireland. You can also use the [HMRC sandbox environment](https://test-developer.service.hmrc.gov.uk/api-documentation/docs/sandbox/introduction) to run tests for Great Britain and Northern Ireland transit movements.

## API status

### API version 2.0

- Supports only NCTS5 Transition State. 
- Currently live in production.

### API version 2.1

- Supports only NCTS5 Final State.
- Ready for testing
- Will not be available for production use until the NCTS5 Final State goes live. Continue using API version 2.0 until then.

## Trader NCTS subscriptions

Any traders who subscribed to the NCTS before NCTS4 must upgrade their NCTS subscriptions before they can use NCTS5.

For information about upgrading an NCTS subscription, see [How to subscribe to the New Computerised Transit System](https://www.gov.uk/guidance/how-to-subscribe-to-the-new-computerised-transit-system).

[Contact the NCTS Helpdesk](https://www.gov.uk/government/organisations/hm-revenue-customs/contact/new-computerised-transit-system-enquiries) if you need any help or advice when using the NCTS.

## Getting started

If you are new to the NCTS and you have not used CTC Traders API v1.0, you should:

1. Review all of this document before reviewing other documents for NCTS5.
2. Review [Trader data](#trader-data).
3. Follow all of the steps in [First-time CTC Traders API users](#first-time-ctc-traders-api-users).
4. Review [Making API requests](#making-api-requests).

Read this section for [Upgrading from NCTS5(v2.0) to NCTS5(v2.1)](#ctc-traders-api-v20-users)


### Trader data

If you work for a software house, each trader you serve must use the [Government Gateway](https://www.access.service.gov.uk/login/signin/creds) to [sign up to the CTC Traders API](https://www.tax.service.gov.uk/customs-enrolment-services/ctc/subscribe?_gl=1*itulmt*_ga*MjA2MDk0MTQyMi4xNjY3Mzk2ODM5*_ga_Y4LWMWY6WS*MTY3NDgyMzU5OC41MS4xLjE2NzQ4NDE2NzcuMC4wLjA.&_ga=2.207635798.536493967.1674469117-2060941422.1667396839) and provide you with the following:

- GB Economic Operators Registration and Identification (EORI) number
- VAT details (optional)
- Standard Industrial Classification (SIC) code
- company or organisation details:
  - unique tax reference (UTR) number
  - registered company name (this must be an exact match)
  - registered company address
  - date of company establishment
- email address
- contact details

### First-time CTC Traders API users

If you have not previously used the CTC Traders API, you should:

1. Ensure that you have an HMRC [developer account](/developer/login) - if you do not have one, you must [register for an account](/developer/registration), activate it by email, and sign in.
2. Add your subscription to this API to your application software.
3. Learn about the user-restricted [authentication](/api-documentation/docs/authorisation/user-restricted-endpoints) used by the API.  
4. [Create an application](/developer/applications/) in our sandbox environment.
5. Use the [Create Test User API](/api-documentation/docs/api/service/api-platform-test-user/1.0) to create one or more test users for your sandbox application.
6. Download [NCTS-P5 reference data](https://ec.europa.eu/taxation_customs/dds2/rd/rd_download_home.jsp?Lang=en) that can be used for testing.
7. Read the [CTC Traders API phase 5 testing guide](/guides/ctc-traders-phase5-testing-guide/) to check that your software is compatible with this version of the API and to learn how to test your application in the sandbox environment.

### CTC Traders API v1.0 users

If you are migrating from CTC Traders API v1.0, you should:

1. Add your subscription to this API to your application software.
2. Download [NCTS-P5 reference data](https://ec.europa.eu/taxation_customs/dds2/rd/rd_download_home.jsp?Lang=en) that can be used for testing.
3. Read the [CTC Traders API phase 5 testing guide](/guides/ctc-traders-phase5-testing-guide/) to check that your software is compatible with this version of the API.

### CTC Traders API v2.0 users

If you are upgrading from NCTS5 (v2.0) to NCTS5 (v2.1) 
and you are familiar with CTC Traders API v2.0, you should:

1. Review this section at least before reviewing other documents for NCTS5.
2. Check whether Trader data applies to any traders you serve - any traders impacted will need to take action.
3. Review Technical Interface Specification(TIS) for updated content
4. Review Making API requests.
5. Review [Test scenarios](https://developer.service.hmrc.gov.uk/guides/ctc-traders-phase5-testing-guide/documentation/test-pack.html) for Phase5 Final.

### Making API requests

Before sending any requests to CTC Traders API v2.1, you should ensure that you are using in your software:

- the correct URL for the environment and API version number
- the correct header contents and payload information - see [CTC Traders API v2.1 reference](/api-documentation/docs/api/service/common-transit-convention-traders/2.1/oas/page)

## Applying for production credentials

### CTC Traders API v2.0 users
Existing users of **CTC Traders API v2.0** do not need to reapply 
for production credentials. However, if you are a new user and 
not yet subscribed to **CTC Traders API v2.0**, you must apply 
for production credentials before accessing the production environment.

To apply for production credentials, please complete the following steps: 
1. Conduct production access testing.
2. Submit an application form.

For more information about how to apply for production credentials 
for the API, see [CTC Traders API phase 5 testing guide](https://developer.service.hmrc.gov.uk/guides/ctc-traders-phase5-testing-guide/).

Use your developer account to apply for production credentials.

## User journeys

These journeys show examples of use:

- [developer setup](documentation/developer-setup.html)
- [upload files for large messages](documentation/upload-files-for-large-messages.html)
- [complete a transit declaration](documentation/complete-transit-declaration.html)
- [submit a transit declaration](documentation/submit-transit-declaration.html)
- [query declarations sent](documentation/query-declarations-sent.html)
- [submit message related to a departure](documentation/submit-message-related-to-departure.html)
- [submit arrival notification](documentation/submit-arrival-notification.html)
- [query arrival notifications sent](documentation/query-arrival-notifications-sent.html)
- [submit message related to an arrival](documentation/submit-message-related-to-arrival.html)
- [get notifications](documentation/get-notifications.html) 

## API endpoints quick reference

The base URLs of the sandbox and production environments are as follows.

| Environment | Base URL                                |
|-------------|-----------------------------------------|
| Sandbox     | `https://test-api.service.hmrc.gov.uk/` |
| Production  | `https://api.service.hmrc.gov.uk/`      |

The following table relates NCTS5 message types to API endpoints.

| Message types       | Action                                                               | Description                            |
|---------------------|----------------------------------------------------------------------|----------------------------------------|
| IE015               | `POST /customs/transits/movements/departures`                        | Send a declaration data message.       |
| IE013, IE014, IE170 | `POST /customs/transits/movements/departures/{departureId}/messages` | Send a message related to a departure. |
| IE007               | `POST /customs/transits/movements/arrivals`                          | Send an arrival notification message.  |
| IE044               | `POST /customs/transits/movements/arrivals/{arrivalId}/messages`     | Send a message related to an arrival.  |

## Message sizes

CTC Traders API v2.0 and v2.1 supports two routes for sending messages to the NCTS. On a per-message basis, you can choose between sending a message to the NCTS by the large message route or by the small message route.

### Differences between large and small message routes

The following table summarises the main differences between the large and small routes supported by the API.

| Attribute                                      | Large message route                      | Small message route |
|------------------------------------------------|------------------------------------------|---------------------|
| Message size limit                             | 8MB                                      | 5MB                 |
| Submission type                                | File-based                               | Direct              |
| Messaging type                                 | Asynchronous                             | Synchronous         |
| Successful message submission feedback         | Near real time (with push notifications) | Immediate           |
| Timeout resilience                             | Strong                                   | Weak                |
| Transit declaration size suitability (average) | Large                                    | Small               |

### Determining which message route to use

You should consider using the large message route if the transit movements that you usually handle contain large consignments.

However, before making any final decisions about how your application software will handle message sizes, consider the following:

- although you can use the large message route to send both large and small messages, only the POST endpoints of the API support the large message route (but all GET endpoints of the API can handle messages of any size)
- rule [G0005](/guides/ctc-traders-phase5-tis/documentation/rules-g.html#g0005) in the [NCTS phase 5 technical interface specification](/guides/ctc-traders-phase5-tis) restricts the declaration goods item number (a master count of goods items lines) in a transit declaration to a maximum of 1,999
- if quick response times from the NCTS matter to you or the traders you serve and if your message sizes never exceed 5MB, you should use only the small messages functionality of the API

If you decide to use the large message route, consider making use of our [Push Pull Notifications API](/api-documentation/docs/api/service/push-pull-notifications-api/1.0) to have automatic notifications sent from the NCTS in near real time.

### Sending large messages

To use the large message route to send a transit declaration, you call the API with an empty payload - a successful response will include:

- a URL and additional metadata that you must use when uploading your file
- a message ID that allows you track the status of that specific message

For more information about sending large messages, see [Upload files for large messages](documentation/upload-files-for-large-messages.html).

## Process flows

For information about NCTS5 process flows, see [NCTS phase 5 technical interface specification](/guides/ctc-traders-phase5-tis/documentation/process_flows.html).

## Terms of use

Your application must comply with [our terms of use](/api-documentation/docs/terms-of-use). You must accept the terms of use before we issue your application’s production credentials.

## Navigating CTC Traders API v2.1 documentation

The following table lists the documents for CTC Traders API v2.0/v2.1 and outlines the content and intended readers of each document.

| Document                                                                                                                                                  | Content type                     | Granularity | Summary                                                                                                                                                                                                                                                     | Intended Readers                                                           |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------|-------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------|
| [CTC Traders API roadmap](https://developer.service.hmrc.gov.uk/roadmaps/common-transit-convention-traders-roadmap/) (covers NCTS4 onwards)               | Functional                       | 	High level | Outlines current status of API for each NCTS phase <br><br> Outlines any development plans for API                                                                                                                                                          | Software developersTechnical architects Product managers Business analysts |
| [NCTS phase 5 technical interface specification](https://developer.service.hmrc.gov.uk/guides/ctc-traders-phase5-tis/) (TIS)                              | Technical (business logic/rules) | Low level	  | Captures UK implementation of NCTS5 <br><br> Shows NCTS5 process flows <br><br> Lists the message definitions and rules and conditions involved in the exchange of messages between traders and the NCTS for the departure and arrival of transit movements | Software developersTechnical architects Product managers Business analysts |
| CTC Traders API phase 5 service guide (this document)                                                                                                     | Technical	                       | 	High level | How to use the APIHow to self-onboard                                                                                                                                                                                                                       | Software developersTechnical architects                                    |
| [CTC Traders API v2.0 reference](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/common-transit-convention-traders/2.0/oas/page) | Technical                        | Low level   | How to use each API endpoint                                                                                                                                                                                                                                | Software developersTechnical architects                                    |
| [CTC Traders API v2.1 reference](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/common-transit-convention-traders/2.1/oas/page) | Technical                        | Low level   | How to use each API endpoint                                                                                                                                                                                                                                | Software developersTechnical architects                                    |
| [CTC Traders API phase 5 testing guide](https://developer.service.hmrc.gov.uk/guides/ctc-traders-phase5-testing-guide/)                                   | Functional                       | Low level   | How to carry out assurance testing of your application software to ensure that it is compatible with the API <br><br> How to carry out production access testing of your software                                                                           | Software developersTechnical architects Product managers Business analysts |



The order in you which you might read these documents can depend on whether you have previous NCTS experience. The following table recommends 2 possible reading orders but you can read the documents in any order you want.

| Suggested reading order | New NCTS users                    | NCTS4 users migrating to NCTS5    |
|-------------------------|-----------------------------------|-----------------------------------|
| 1                       | Roadmap                           | Service guide                     |
| 2                       | Service guide                     | Technical interface specification |
| 3                       | Technical interface specification | Reference                         |
| 4                       | Reference                         | Testing guide                     |
| 5                       | Testing guide                     | Roadmap                           |

**Note:** If you have NCTS4 experience,  it is important that you read the NCTS5 service guide and API reference carefully to understand all of the differences between NCTS4 and NCTS5. Reading only the NCTS5 technical interface specification will NOT guide you about all of the differences between the 2 NCTS phases.

## Related documentation

- [CTC Traders API v2.0 changelog](https://github.com/hmrc/common-transit-convention-traders/wiki/CTC-Traders-API-v2.0-changelog) (GitHub)
- [CTC Traders API v2.1 changelog](https://github.com/hmrc/common-transit-convention-traders/wiki/CTC-Traders-API-v2.0-changelog) (GitHub)
- [NCTS phase 4-phase 5 data mapping spreadsheet](/guides/ctc-traders-phase5-tis/downloads/NCTS-P5_Datamapping_R5_111023_v1.0.xlsx) (GitHub)
- [Transit Manual Supplement](https://www.gov.uk/government/publications/transit-manual-supplement) - UK transit procedures (OpenDocument Text document)

## Getting help and support

Before contacting us, find out if there is planned API downtime or a technical issue by checking [HMRC API Platform Status](https://api-platform-status.production.tax.service.gov.uk/?_ga=2.139406967.536493967.1674469117-2060941422.1667396839) and [New Computerised Transit System service availability](https://www.gov.uk/guidance/new-computerised-transit-system-service-availability?_ga=2.174532070.536493967.1674469117-2060941422.1667396839).

If you have specific questions about the CTC Traders API, contact our Software Developer Support (SDS) Team. You’ll get an initial response within 2 working days.

You can also email questions to [SDSTeam@hmrc.gov.uk](mailto:SDSTeam@hmrc.gov.uk). We might ask for more detailed information when we respond.

## Changelog

You can find the changelog for this document in the [ctc-traders-phase5-service-guide](https://github.com/hmrc/ctc-traders-phase5-service-guide/wiki/CTC-Traders-API-phase-5-service-guide-changelog) GitHub wiki.

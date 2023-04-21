---
title: CTC Traders API phase 5 service guide
weight: 1
description: Software developers, designers, product owners or business analysts. Send departure and arrival movement notifications to the NCTS.
---

# CTC Traders API phase 5 service guide

Learn how to use [CTC Traders API v2.0](/api-documentation/docs/api/service/common-transit-convention-traders/2.0) with your software.

## API overview

The CTC Traders API is based on REST principles with endpoints that return data in JSON format and it uses standard HTTP error response codes.

Use the API to:

- send departure and arrival movement notifications to the New Computerised Transit System (NCTS)
- retrieve messages sent from customs offices of departure and destination

The API endpoints relate only to Great Britain and Northern Ireland. You can also use the [HMRC sandbox environment](https://test-developer.service.hmrc.gov.uk/api-documentation/docs/sandbox/introduction) to run tests for Great Britain and Northern Ireland transit movements.

## API status

This version of the CTC Traders API: 

- supports only NCTS phase 5 ([CTC Traders API v1.0](/api-documentation/docs/api/service/common-transit-convention-traders/1.0) supports only phase 4)
- is currently ready for testing
- will not be ready for use in production until phase 5 goes live - in the meantime, you should continue using CTC Traders API v1.0

To meet the requirements of the Common Transit Convention (CTC), all member countries must transfer to phase 5 by 30 November 2023.

There will be a cutover period after phase 5 goes live. During this period, the NCTS phase 4 service will continue running to deal with in-flight transit declarations submitted before go-live while the phase 5 service will handle all new declarations. The phase 5 service will not hold information about any declarations submitted before the go-live date.

## Trader CTC enrolments

NCTS phase 5 is due to go live during November 2023 and a legacy Common Transit Convention (CTC) enrolment will not be accepted on phase 5, so obtaining a new CTC enrolment is a mandatory requirement. A legacy CTC enrolment is an enrolment for phase 3 or earlier of the NCTS.

**Deadline:** Traders must migrate from legacy CTC enrolments before 31 March 2023.

There is no upgrade path from phase 3 or earlier to phase 5. Instead, if traders have not already done so, they must first upgrade to phase 4.

To get a new CTC enrolment for phases 4 and 5, traders must complete the following steps:

1. [Get a new Electronic Customs Clearance (ECC) enrolment](https://www.gov.uk/government/publications/new-computerised-transit-system-ncts-how-to-register-and-enrol).
2. [Get an EORI number](https://www.gov.uk/eori) (if needed).
3. Start using only your new CTC enrolment for making all of your customs declarations.

[Contact the NCTS Helpdesk](https://www.gov.uk/government/organisations/hm-revenue-customs/contact/new-computerised-transit-system-enquiries) if you need any help or advice when using the NCTS.

## Getting started

If you are new to the NCTS and you have not used CTC Traders API v1.0, you should:

1. Review all of this document before reviewing other documents for phase 5.
2. Review [Trader data](#trader-data).
3. Follow all of the steps in [First-time CTC Traders API users](#first-time-ctc-traders-api-users).
4. Review [Making API requests](#making-api-requests).

If you are migrating from NCTS phase 4 to phase 5 and you are familiar with CTC Traders API v1.0, you should:

1. Review this section at least before reviewing other documents for phase 5.
2. Check whether [Trader data](#trader-data) applies to any traders you serve - any traders impacted will need to take action.
3. Follow any steps in [CTC Traders API  v1.0 users](#ctc-traders-api-v1-0-users) that apply to you.
4. Review [Making API requests](#making-api-requests).

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
7. Read the testing guide (pending) to check that your software is compatible with this version of the API and to learn how to test your application in the sandbox environment.

### CTC Traders API v1.0 users

If you are migrating from CTC Traders API v1.0, you should:

1. Add your subscription to this API to your application software.
2. Download [NCTS-P5 reference data](https://ec.europa.eu/taxation_customs/dds2/rd/rd_download_home.jsp?Lang=en) that can be used for testing.
3. Read the testing guide (pending) to check that your software is compatible with this version of the API.

### Making API requests

Before sending any requests to CTC Traders API v2.0, you should ensure that you are using in your software:

- the correct URL for the environment and API version number
- the correct header contents and payload information - see [CTC Traders API v2.0 reference](/api-documentation/docs/api/service/common-transit-convention-traders/2.0/oas/page)

## Applying for production credentials

Before you can use the production environment for CTC Traders API v2.0, you must:

1. Complete the CTC Traders API Application for Production Credentials Checklist (pending), which involves submitting test results that are no more than 14 days old (see testing guide).
2. Use your [developer account](/developer/login) to apply for production credentials.


## User journeys

These journeys show examples of use:

- [developer setup](documentation/developer-setup.html)
- [submit a transit declaration](documentation/submit-transit-declaration.html)
- [query declarations sent](documentation/query-declarations-sent.html)
- [submit message related to a departure](documentation/submit-message-related-to-departure.html)
- [submit arrival notification](documentation/submit-arrival-notification.html)
- [query arrival notifications sent](documentation/query-arrival-notifications-sent.html)
- [submit message related to an arrival](documentation/submit-message-related-to-arrival.html)
- [get notifications](documentation/get-notifications.html) 

## Process flows

For information about NCTS phase 5 process flows, see [NCTS phase 5 technical interface specification](/guides/ctc-traders-phase5-tis/documentation/process_flows.html).

## Terms of use

Your application must comply with [our terms of use](/api-documentation/docs/terms-of-use). You must accept the terms of use before we issue your application’s production credentials.

## Related documentation

- [CTC Traders API roadmap](/roadmaps/common-transit-convention-traders-roadmap/)
- [CTC Traders API v2.0 reference](/api-documentation/docs/api/service/common-transit-convention-traders/2.0/oas/page)
- [CTC Traders API v2.0 changelog](https://github.com/hmrc/common-transit-convention-traders/wiki/CTC-Traders-API-v2.0-changelog) (GitHub)
- CTC Traders API phase 5 testing guide (pending)
- [NCTS phase 5 technical interface specification](/guides/ctc-traders-phase5-tis/)
- [NCTS phase 4-phase 5 data mapping spreadsheet](https://github.com/hmrc/ctc-traders-phase5-tis/blob/main/source/figures/NCTS-P5_Datamapping_R3_140323_v1.0.xlsx) (GitHub)
- [Transit Manual Supplement](https://www.gov.uk/government/publications/transit-manual-supplement) - UK transit procedures (OpenDocument Text document)

## Getting help and support

Before contacting us, find out if there is planned API downtime or a technical issue by checking [HMRC API Platform Status](https://api-platform-status.production.tax.service.gov.uk/?_ga=2.139406967.536493967.1674469117-2060941422.1667396839) and [New Computerised Transit System service availability](https://www.gov.uk/guidance/new-computerised-transit-system-service-availability?_ga=2.174532070.536493967.1674469117-2060941422.1667396839).

If you have specific questions about the CTC Traders API, contact our Software Developer Support (SDS) Team. You’ll get an initial response within 2 working days.

You can also email questions to [SDSTeam@hmrc.gov.uk](mailto:SDSTeam@hmrc.gov.uk). We might ask for more detailed information when we respond.

## Changelog

You can find the changelog for this document in the [ctc-traders-phase5-service-guide](https://github.com/hmrc/ctc-traders-phase5-service-guide/wiki/CTC-Traders-API-phase-5-service-guide-changelog) GitHub wiki.

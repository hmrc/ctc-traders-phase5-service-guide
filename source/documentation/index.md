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

## Quick start

Learn how to get started with the CTC Traders API.

If you are new to the NCTS, you should review all of this document before reviewing other documents for phase 5. If you are migrating from NCTS phase 4 to phase 5, you should review this section at least before reviewing other documents for phase 5.

### Before you start

Before you start using the CTC Traders API, you should:

- ensure that you have an HMRC [developer account](/developer/login) - if you don’t have one, you must [register for an account](/developer/registration), activate it by email, and sign in
- add your subscription to this API to your application
- learn about the user-restricted [authentication](/api-documentation/docs/authorisation/user-restricted-endpoints) used by the API  
- [create an application](/developer/applications/) in our sandbox environment
- use the [Create Test User API](/api-documentation/docs/api/service/api-platform-test-user/1.0) to create one or more test users for your sandbox application
- download [NCTS-P5 reference data](https://ec.europa.eu/taxation_customs/dds2/rd/rd_download_home.jsp?Lang=en) that can be used for testing
- read the testing guide (pending) to check that your software is compatible with this version of the API and to learn how to test your application in the sandbox environment

### Production environment requirements

Before you can use the production environment for the CTC Traders API, you must:

- complete the CTC Traders API Application for Production Credentials Checklist (pending)
- use your [developer account](/developer/login) to apply for production credentials

### Get your customers ready

If you work for as software house, each trader you serve must use the [Government Gateway](https://www.access.service.gov.uk/login/signin/creds) to [sign up to the CTC Traders API](https://www.tax.service.gov.uk/customs-enrolment-services/ctc/subscribe?_gl=1*itulmt*_ga*MjA2MDk0MTQyMi4xNjY3Mzk2ODM5*_ga_Y4LWMWY6WS*MTY3NDgyMzU5OC41MS4xLjE2NzQ4NDE2NzcuMC4wLjA.&_ga=2.207635798.536493967.1674469117-2060941422.1667396839) and provide you with the following:

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
- [NCTS phase 4-phase 5 data mapping spreadsheet](https://github.com/hmrc/ctc-traders-phase5-tis/blob/main/source/figures/NCTS-P5_Datamapping_R2_190123_v1.0.xlsx) (GitHub)
- [Transit Manual Supplement](https://www.gov.uk/government/publications/transit-manual-supplement) - UK transit procedures (OpenDocument Text document)

## Getting help and support

Before contacting us, find out if there is planned API downtime or a technical issue by checking [HMRC API Platform Status](https://api-platform-status.production.tax.service.gov.uk/?_ga=2.139406967.536493967.1674469117-2060941422.1667396839) and [New Computerised Transit System service availability](https://www.gov.uk/guidance/new-computerised-transit-system-service-availability?_ga=2.174532070.536493967.1674469117-2060941422.1667396839).

If you have specific questions about the CTC Traders API, contact our Software Developer Support (SDS) Team. You’ll get an initial response within 2 working days.

You can also email questions to [SDSTeam@hmrc.gov.uk](mailto:SDSTeam@hmrc.gov.uk). We might ask for more detailed information when we respond.

## Changelog

You can find the changelog for this document in the [ctc-traders-phase5-service-guide](https://github.com/hmrc/ctc-traders-phase5-service-guide/wiki/CTC-Traders-API-phase-5-service-guide-changelog) GitHub wiki.

---
title: CTC Traders phase 5 service guide
weight: 1
description: Software developers, designers, product owners or business analysts. Integrate your software with Common Transit Convention Traders API.
---

# CTC Traders API phase 5 service guide

## Useful CTC Page Links
[CTC Traders API roadmap](/roadmaps/common-transit-convention-traders-roadmap/#phase-5)

[CTC Traders API specification](/api-documentation/docs/api/service/common-transit-convention-traders/2.0)

[NCTS Phase 5 Technical Interface Specification](/guides/ctc-traders-phase5-tis)



## Introduction
This guide explains how to use the Common Transit Convention (CTC) Traders API with your software.

The CTC Traders API allows traders to send and receive arrival and departure movements to and from the New Computerised Transit System (NCTS) for Great Britain and Northern Ireland.

**Note:** Current development focuses on small messages (0.5MB and below only). Development for messages larger than 0.5MB will begin at a later date.

## Changelog

You can find the changelog in the [ctc-traders-phase5-service-guide](https://github.com/hmrc/ctc-traders-phase5-service-guide/wiki/CTC-Traders-API-phase-5-service-guide-changelog) GitHub wiki.

## Getting Started

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

## Process flows
Process flows are available in the [NCTS Phase 5 Technical Interface Specification](/guides/ctc-traders-phase5-tis).

## NCTS Message Details

### XSD - XML Schema Definition
The API uses XSD templates to validate all the Information Exchange (IE) messages that come into the system.

If there are any problems, the IE message will be rejected with a 400 BadRequest status which will contain an explanation of the problem.

The XML schemas are available for download [here](https://github.com/hmrc/transit-movements-validator/tree/main/conf/xsd).

### Information Exchange messages

These are standard messages sent to and received from NCTS. For details, see the [NCTS Phase 5 Technical Interface Specification](/guides/ctc-traders-phase5-tis).

## API features

### Rate limits

Our API Platform’s standard rate limit is [3 requests per second](/api-documentation/docs/reference-guide#rate-limiting). If you need a higher rate limit, you must give us more information about data and limit forecasts when filling in the Application for Production Credentials checklist form (**currently unavailable**).

## Get Support

Before you get in touch, find out if there are any planned API downtime or technical issues by checking:

 - [HMRC API Platform availability](https://api-platform-status.production.tax.service.gov.uk/)
 - [NCTS service availability](https://www.gov.uk/government/publications/new-computerised-transit-system-ncts-web-service-availability-and-issues/new-computerised-transit-system-ncts-web-service-availability-and-issues)

If you have specific questions about the CTC Traders API, get in touch with our Software Developer Support Team.

You’ll get an initial response in 2 working days.

Email us your questions to [SDSTeam@hmrc.gov.uk](mailto:SDSTeam@hmrc.gov.uk). We might ask for more detailed information when we respond.

**Useful Links**

 - [CTC Traders API roadmap](/roadmaps/common-transit-convention-traders-roadmap/#phase-5)
 - [CTC Traders API phase 5 specification](/api-documentation/docs/api/service/common-transit-convention-traders/2.0)

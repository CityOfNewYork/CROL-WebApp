{
"@context": "http://publicnotice.io",
"@type": "http://publicnotice.io/Notice",
"noticeId": "${RequestID}",
"noticeTitle": "${ShortTitle}",
"noticeDescription": "${AdditionalDescription}",
"section": {
  "@type": "http://publicnotice.io/Section",
  "id": "${SectionID}",
  "name": "${SectionName}"
  },
"issuingOrganization": {
  "@type": "Organization",
  "@context": "http://schema.org",
  "address": {
    "@type": "PostalAddress",
    "addressLocality": "",
    "addressRegion": "",
    "postalCode": "",
    "streetAddress": "",
    "borough": "" 
  },
  "email": "",
  "faxNumber": "",
  "parent": {
    "@id":"http://www.w3.org/ns/org#subOrganizationOf",
    "@type": "Organization",
    "address": {
      "@type": "PostalAddress",
      "addressLocality": "",
      "addressRegion": "",
      "postalCode": "",
      "streetAddress": "",
      "borough": "" 
    },
    "email": "",
    "faxNumber": "",
    "parent": {
    "@id":"http://www.w3.org/ns/org#subOrganizationOf"
    },
    "name": "",
    "classification": "",
    "identifier":"",
    "telephone": "",
    "url": "",
    "alternateName": ""
    },
  "name": "${AgencyName}",
  "classification": "Agency",
  "identifier": "${AgencyCode}",
  "telephone": "",
  "url": "",
  "alternateName": ""
  },
"StartDate": "${StartDate}",
"EndDate": "${EndDate}",
"otherInfo": "${OtherInfo}",
"printout": "${Printout}",
"agendaItems": [
  {
  "@type": "http://publicnotice.io/Item",
  "itemDescription": "",
  "itemObject": {
    "itemObjectId":"",
    "itemObjectText":""
    },
  "itemAction": {
    "itemActionId":"",
    "itemActionText":""
    },
  "itemAdminContext": {
    "itemAdminContextId":"",
    "itemAdminContextText":""
    },
  "itemDocContext": {
    "itemDocContextId":"",
    "itemDocContextText":""
    }
  }
  ],
"attributes": {
  "@type": "http://publicnotice.io/Attributes",
${ParserOutput}
,
  "refOrganization": [
  {
      "@type": "Organization",
      "@context": "http://schema.org",
      "address": {
        "@type": "PostalAddress",
        "addressLocality": "",
        "addressRegion": "",
        "postalCode": "",
        "streetAddress": "",
        "borough": "" 
      },
      "email": "",
      "faxNumber": "",
      "parent": {"@id":"http://www.w3.org/ns/org#subOrganizationOf"},
      "name": "",
      "legalName": "",
      "classification": "",
      "identifier":"",
      "telephone": "",
      "url": "",
      "alternateName": ""}
      ],
  "refPerson": [
    {
      "@context": "http://schema.org",
      "@type": "Person",
      "jobTitle": "",
      "name": "",
      "url": ""
    }
      ],
  "refMeeting": [
      { 
      "@type": "Event",
      "@context": "http://schema.org",
      "name": "",
      "startDate": "",
      "endDate": "",
      "location": {
          "@type": "Place",
          "name": "",
        "address": {
            "@type": "PostalAddress",
            "addressLocality": "",
            "addressRegion": "",
            "postalCode": "",
            "streetAddress": "",
            "borough": ""     
            },
          "geo": {
            "@type": "GeoCoordinates",
            "latitude": "",
            "longitude": ""
            }
        }
      }
      ],
  "attachment":[
      {
      "@type": "http://publicnotice.io/Document",
       "id": "",
       "documentType":"",
       "title":"",
       "description":"",
       "url":"",
       "datePublished":"",
       "dateModified":"",
       "format":"",
       "language":""
       }
      ]
  },
"dateCreated": "",
"dateModified": "",
"noticeType": {
    <#if TypeOfNoticeCode=="1">
    "@context": "http://opencontracting.org",
    "@type": "http://opencontracting.org/Tender",
      "uri": "",
      "publishedDate": "${StartDate}",
      "publisher": {
          "name": "Department of Citywide Administrative Services",
          "uri": "http://www.nyc.gov/html/dcas/"
      },
      "releases": [
          {
              "ocid": "ocds-1nsder-${PIN}",
              "id": "ocds-1nsder-${PIN}-${RequestID}",
              "language": "en",
              "date": "${StartDate}",
              "tag": [
                  "tender"
              ],
              "initiationType": "tender",
              "planning": {},
              "tender": {
                  "id": "ocds-1nsder-${PIN}",
                  "title": "${ShortTitle}",
                  "description": "${AdditionalDescription}",
                  "status": "active",
                  "items": [ 
                      {
                          "id": 1,
                          "description": "",
                          "classification": {
                              "scheme": "",
                              "id": "",
                              "uri": "",
                              "description": "${CategoryDescription}"
  }
                      }
                  ],
                  "value": {
                      "currency": "USD",
                      "amount":  "${ContractAmount}"
                  },
                  "tenderPeriod": {
                      "startDate": "${StartDate}", 
                      "endDate": "${DueDate}"
                  }, 
                  "procurementMethod": "open",
                  "procurementMethodDetails": {
                      "id": "${SelectionMethodCode}",
                      "name": "${SelectionMethodDescription}"
                  },
                  "procurementMethodRationale": {
                      "id": "${SpecialCaseReasonCode}",
                      "name": "${SpecialCaseReasonDescription}"
                  },
              "submissionMethod": "written", 
              "submissionMethodDetails" : {
                "instruction": "Use the following address unless otherwise specified in notice, to secure, examine or submit bid/proposal documents, vendor pre-qualification and other forms; specifications/ blueprints; other information; and for opening and reading of bids at date and time specified above.",
                "addressToSubmit": {
                 "@context": "http://schema.org",
                  "address": {
                    "@type": "PostalAddress",
                    "addressLocality": "New York City",
                    "addressRegion": "NY",
                    "postalCode": "",
                    "streetAddress": "${AddressToSubmit}",
                    "borough": "" 
                    },
                  "contactPoint": { 
                    "@type" : "ContactPoint",
                    "telephone" : "${ContactPhone}",
                    "faxNumber": "${ContactFax}",
                    "name": "${ContactName}",
                    "email": "${Email}"
                    }
                    }
              }, 
              "buyer": {
    "@type": "Organization",
    "@context": "http://schema.org",
     "address": {
      "@type": "PostalAddress",
      "addressLocality": "",
      "addressRegion": "",
      "postalCode": "",
      "streetAddress": "",
      "borough": "" 
    },
    "name": "${AgencyName}",
    "alternateName": "",
    "url": "",
    "classification": "Agency",
    "identifier": "${AgencyCode}",
    "email": "",
    "faxNumber": "",
    "telephone": ""
            }
            }
            } 
            ]
<#elseif TypeOfNoticeCode=="2">
"@context": "http://opencontracting.org",
    "@type": "http://opencontracting.org/Award",
      "uri": "",
      "publishedDate": "${StartDate}",
      "publisher": {
          "name": "Departmment of Citywide Administrative Services",
          "uri": "http://www.nyc.gov/html/dcas/"
      },
      "releases": [
          {
              "ocid": "ocds-1nsder-${PIN}",
              "id": "ocds-1nsder-${PIN}-${RequestID}",
              "language": "en",
              "date": "${StartDate}",
              "tag": [
                  "award"
              ],
              "initiationType": "tender",
              "planning": {},
              "tender": {
                  "status": "complete",
                  "items": [ 
                      {
                          "id": 1,
                          "description": "",
                          "classification": {
                              "scheme": "",
                              "id": "",
                              "uri": "",
                              "description": "${CategoryDescription}"
  }
                      }
                  ],
                
                  "procurementMethod": "open",
                  "procurementMethodDetails": {
                      "id": "${SelectionMethodCode}",
                      "name": "${SelectionMethodDescription}"
                  },
                  "procurementMethodRationale": {
                      "id": "${SpecialCaseReasonCode}",
                      "name": "${SpecialCaseReasonDescription}"
                  },              
                "addressToSubmit": {
                 "@context": "http://schema.org",
                  "address": {
                    "@type": "PostalAddress",
                    "addressLocality": "New York City",
                    "addressRegion": "NY",
                    "postalCode": "",
                    "streetAddress": "${AddressToSubmit}",
                    "borough": "" 
                    },
                  "contactPoint": { 
                    "@type" : "ContactPoint",
                    "telephone" : "${ContactPhone}",
                    "faxNumber": "${ContactFax}",
                    "name": "${ContactName}",
                    "email": "${Email}"
                    }
                    }
              }, 
              "awards": [
                    {
                        "id": "ocds-1nsder-${PIN}-${RequestID}", 
                        "title": "${ShortTitle}", 
                        "description": "${AdditionalDescription}", 
                        "status": "active", 
                        "date": "${StartDate}", 
                        "value": {
                            "currency": "USD", 
                            "value": "${ContractAmount}"
                        }, 
                        "suppliers": [
                            {
                                "identifier": {
                                    "scheme": "", 
                                    "id": ""
                                }, 
                                "alternateIdentifier": {
                                    "scheme": "", 
                                    "id": ""
                                }, 
                                "name": "${VendorName}", 
                                "address": {
                                    "streetAddress": "${VendorAddress}"
                                }, 
                                "contactPoint": {
                                    "name": ""
                                }
                            }
                        ]
                    }
                ], 
              "contracts": [
                  {
                      "id": "ocds-1nsder-${PIN}-${RequestID}-${ContractAmount}", 
                      "awardID": "ocds-1nsder-${PIN}-${RequestID}", 
                      "title": "${SelectionMethodDescription}: ${ShortTitle}", 
                      "value": {
                          "currency": "USD", 
                          "amount": "${ContractAmount}"
                      }, 
                      "period": {
                          "startDate": "", 
                          "endDate": ""
                      }
                  }
              ],
              "buyer": {
    "@type": "Organization",
    "@context": "http://schema.org",
     "address": {
      "@type": "PostalAddress",
      "addressLocality": "",
      "addressRegion": "",
      "postalCode": "",
      "streetAddress": "",
      "borough": "" 
    },
    "name": "${AgencyName}",
    "alternateName": "",
    "url": "",
    "classification": "Agency",
    "identifier": "${AgencyCode}",
    "email": "",
    "faxNumber": "",
    "telephone": ""
            }
            }     
            ]
<#elseif TypeOfNoticeCode=="4">
   "@type": "http://opencontracting.org/Award",
"@context": "http://opencontracting.org",
      "uri": "",
      "publishedDate": "${StartDate}",
      "publisher": {
          "name": "Departmment of Citywide Administrative Services",
          "uri": "http://www.nyc.gov/html/dcas/"
      },
      "releases": [
          {
              "ocid": "ocds-1nsder-${PIN}",
              "id": "ocds-1nsder-${PIN}-${RequestID}",
              "language": "en",
              "date": "${StartDate}",
              "tag": [
                  "award"
              ],
              "initiationType": "tender",
              "planning": {},
              "tender": {
                  "status": "complete",
                  "items": [ 
                      {
                          "id": 1,
                          "description": "",
                          "classification": {
                              "scheme": "",
                              "id": "",
                              "uri": "",
                              "description": "${CategoryDescription}"
  }
                      }
                  ],
                
                  "procurementMethod": "open",
                  "procurementMethodDetails": {
                      "id": "${SelectionMethodCode}",
                      "name": "${SelectionMethodDescription}"
                  },
                  "procurementMethodRationale": {
                      "id": "${SpecialCaseReasonCode}",
                      "name": "${SpecialCaseReasonDescription}"
                  },              
                "addressToSubmit": {
                 "@context": "http://schema.org",
                  "address": {
                    "@type": "PostalAddress",
                    "addressLocality": "New York City",
                    "addressRegion": "NY",
                    "postalCode": "",
                    "streetAddress": "${AddressToSubmit}",
                    "borough": "" 
                    },
                  "contactPoint": { 
                    "@type" : "ContactPoint",
                    "telephone" : "${ContactPhone}",
                    "faxNumber": "${ContactFax}",
                    "name": "${ContactName}",
                    "email": "${Email}"
                    }
                    }
              }, 
              "awards": [
                    {
                        "id": "ocds-1nsder-${PIN}-${RequestID}", 
                        "title": "${ShortTitle}", 
                        "description": "${AdditionalDescription}", 
                        "status": "pending", 
                        "date": "${StartDate}", 
                        "value": {
                            "currency": "USD", 
                            "value": "${ContractAmount}"
                        }, 
                        "suppliers": [
                            {
                                "identifier": {
                                    "scheme": "", 
                                    "id": ""
                                }, 
                                "alternateIdentifier": {
                                    "scheme": "", 
                                    "id": ""
                                }, 
                                "name": "${VendorName}", 
                                "address": {
                                    "streetAddress": "${VendorAddress}"
                                }, 
                                "contactPoint": {
                                    "name": ""
                                }
                            }
                        ]
                    }
                ], 
              "buyer": {
    "@type": "Organization",
    "@context": "http://schema.org",
     "address": {
      "@type": "PostalAddress",
      "addressLocality": "",
      "addressRegion": "",
      "postalCode": "",
      "streetAddress": "",
      "borough": "" 
    },
    "name": "${AgencyName}",
    "alternateName": "",
    "url": "",
    "classification": "Agency",
    "identifier": "${AgencyCode}",
    "email": "",
    "faxNumber": "",
    "telephone": ""
            }
            }     
            ]
<#elseif TypeOfNoticeCode=="3">
    "@context": "http://opencontracting.org",
    "@type": "http://opencontracting.org/Tender",
      "uri": "",
      "publishedDate": "${StartDate}",
      "publisher": {
          "name": "Departmment of Citywide Administrative Services",
          "uri": "http://www.nyc.gov/html/dcas/"
      },
      "releases": [
          {
              "ocid": "ocds-1nsder-${RequestID}",
              "id": "ocds-1nsder-${RequestID}",
              "language": "en",
              "date": "${StartDate}",
              "tag": [
                  "tender"
              ],
              "initiationType": "tender",
              "planning": {},
              "tender": {
                  "id": "ocds-1nsder-${RequestID}",
                  "title": "${ShortTitle}",
                  "description": "${AdditionalDescription}",
                  "status": "active",
                  "items": [ 
                      {
                          "id": 1,
                          "description": "",
                          "classification": {
                              "scheme": "",
                              "id": "",
                              "uri": "",
                              "description": "${CategoryDescription}"
  }
                      }
                  ],
                  "tenderPeriod": {
                      "startDate": "${StartDate}", 
                      "endDate": "${DueDate}"
                  }, 
                  "procurementMethod": "open",
                  "procurementMethodDetails": {
                      "id": "${SelectionMethodCode}",
                      "name": "${SelectionMethodDescription}"
                  },
                  "procurementMethodRationale": {
                      "id": "${SpecialCaseReasonCode}",
                      "name": "${SpecialCaseReasonDescription}"
                  },
              "submissionMethod": "written", 
              "submissionMethodDetails" : {
                "instruction": "Use the following address unless otherwise specified in notice, to secure, examine or submit bid/proposal documents, vendor pre-qualification and other forms; specifications/ blueprints; other information; and for opening and reading of bids at date and time specified above.",
                "addressToSubmit": {
                 "@context": "http://schema.org",
                  "address": {
                    "@type": "PostalAddress",
                    "addressLocality": "New York City",
                    "addressRegion": "NY",
                    "postalCode": "",
                    "streetAddress": "${AddressToSubmit}",
                    "borough": "" 
                    },
                  "contactPoint": { 
                    "@type" : "ContactPoint",
                    "telephone" : "${ContactPhone}",
                    "faxNumber": "${ContactFax}",
                    "name": "${ContactName}",
                    "email": "${Email}"
                    }
                    }
              }, 
              "buyer": {
    "@type": "Organization",
    "@context": "http://schema.org",
     "address": {
      "@type": "PostalAddress",
      "addressLocality": "",
      "addressRegion": "",
      "postalCode": "",
      "streetAddress": "",
      "borough": "" 
    },
    "name": "${AgencyName}",
    "alternateName": "",
    "url": "",
    "classification": "Agency",
    "identifier": "${AgencyCode}",
    "email": "",
    "faxNumber": "",
    "telephone": ""
            }
            }
            } 
            ]
<#elseif TypeOfNoticeCode=="11">
      "@type": "http://publicnotice.io/PublicHearing",
      "eventId": "" 
<#else>
"@type": "http://publicnotice.io/Other"
</#if>
}
}
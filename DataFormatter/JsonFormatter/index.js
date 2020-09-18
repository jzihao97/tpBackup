// const details = require('./moduleInfo.js');
// const list = require('./moduleList.js');

// var templateObj = {
//   moduleCode: "",
//   title: "",
//   description: "",
//   moduleCredit: "",
//   department: "",
//   faculty: "",
//   workload: "",
//   semesterData: {
//     semester: "",
//     examDate: "",
//     examDuration: "",
//   },
//   preclusion: "",
//   attributes: {
//     su: false,
//     sfs: false,
//     ssgf: false,
//     ism: false,
//     fyp: false,
//     year: false,
//     grsu: false,
//     lab: false,
//     urop: false,
//   },
//   prerequisite: "",
//   corequisite: "",
// }

// console.log("this is the length of the list: " + list.length);
// console.log("this is the length of details: " + details.length);

// for (var i = 0; i < list.length; i++ ){
//   console.log(list[i]);
// }

//     su: false, Index 0 of attribute
//     sfs: false, Index 1 of attribute
//     ssgf: false, Index 2 of attribute
//     ism: false, Index 3 of attribute
//     fyp: false, Index 4 of attribute
//     year: false, Index 5 of attribute
//     grsu: false, Index 6 of attribute
//     lab: false, Index 7 of attribute
//     urop: false, Index 8 of attribute

import {details} from './moduleInfo.js';
import {list} from './moduleList.js';
import {data} from './data.js';
import fs from 'fs';
import { Console } from 'console';

var generation = false;
var checking = true;

if (generation === true) {
  var templateObj = {
    moduleCode: "",
    title: "",
    moduleCredit: "",
    department: "",
    faculty: "",
    semester: [],
    preclusion: "",
    attributes: [false, false, false, false, false, false, false, false, false],
    prerequisite: "",
    corequisite: "",
  }
  
  var finalArr = [];
  
  
  var counter = 0;
  // console.log(details[1797].attributes.su);
  for (var i = 0; i < details.length; i++ ){
    var newObj = JSON.parse(JSON.stringify(templateObj)); //Deep clone, take note
  
    newObj.moduleCode = details[i].moduleCode;
    newObj.title = details[i].title;
    newObj.moduleCredit = parseInt(details[i].moduleCredit);
    newObj.department = details[i].department;
    newObj.faculty = details[i].faculty;
    
    if (details[i].preclusion !== undefined) {
      newObj.preclusion = details[i].preclusion;
    }
  
    if (details[i].prerequisite !== undefined) {
      newObj.prerequisite = details[i].prerequisite;
    }
    
    if (details[i].corequisite !== undefined) {
      newObj.corequisite = details[i].corequisite;
    }
  
    // console.log(newObj.attributes);
    // console.log(details[i].attributes)
  
    if (details[i].attributes !== undefined) {
        if (details[i].attributes.su === true) {
          newObj.attributes[0] = true;
        } 
    
        if (details[i].attributes.sfs === true) {
          newObj.attributes[1] = true;
        }
    
        if (details[i].attributes.ssgf === true) {
          newObj.attributes[2] = true;
        }
    
        if (details[i].attributes.ism === true) {
          newObj.attributes[3] = true;
        }
        
        if (details[i].attributes.fyp === true) {
          newObj.attributes[4] = true;
        }
    
        if (details[i].attributes.year === true) {
          newObj.attributes[5] = true;
        }
    
        if (details[i].attributes.grsu === true) {
          newObj.attributes[6] = true;
        }
    
        if (details[i].attributes.lab === true) {
          newObj.attributes[7] = true;
        }
    
        if (details[i].attributes.urop === true) {
          newObj.attributes[8] = true;
        }
    }
  
    var tempSemData = [];
    if (details[i].semesterData !== undefined) {
      for (var j = 0; j < details[i].semesterData.length; j++) {
        // console.log("inside j (" + j + "): " + details[i].semesterData[j].semester);
        tempSemData.push(details[i].semesterData[j].semester);
      }
    }
    newObj.semester = tempSemData;
  
    console.log(newObj);
    finalArr.push(newObj);
    counter++;
  }
  
  console.log(counter);
  
  fs.writeFile('out.json', JSON.stringify(finalArr, null, 4), function(err, result) {
    if (err) {
      console.log(err);
    }
  });
}

if (checking === true) {
  var max = 0;

  for (var i = 0; i < data.length; i++) {
    // console.log(data[i].moduleCode);
    if(data[i].moduleCode.length > max) {
      console.log(data[i].moduleCode);
      max = data[i].moduleCode.length;
    }
  }

  console.log(max);
}

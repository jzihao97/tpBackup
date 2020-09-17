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
//   attibutes: {
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
    attibutes: [false, false, false, false, false, false, false, false, false],
    prerequisite: "",
    corequisite: "",
  }
  
  var finalArr = [];
  
  for (var i = 0; i < details.length; i++ ){
    // console.log(details[i]);
    var newObj = {...templateObj};
  
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
    
    if (details[i].attibutes !== undefined) {
      for (var k = 0; k < details[i].attibutes.length; k++) {
        if (details[i].attibutes[k].su === true) {
          newObj.attibutes[0] = true;
        }
    
        if (details[i].attibutes[k].sfs === true) {
          newObj.attibutes[1] = true;
        }
    
        if (details[i].attibutes[k].ssgf === true) {
          newObj.attibutes[2] = true;
        }
    
        if (details[i].attibutes[k].ism === true) {
          newObj.attibutes[3] = true;
        }
        
        if (details[i].attibutes[k].fyp === true) {
          newObj.attibutes[4] = true;
        }
    
        if (details[i].attibutes[k].year === true) {
          newObj.attibutes[5] = true;
        }
    
        if (details[i].attibutes[k].grsu === true) {
          newObj.attibutes[6] = true;
        }
    
        if (details[i].attibutes[k].lab === true) {
          newObj.attibutes[7] = true;
        }
    
        if (details[i].attibutes[k].urop === true) {
          newObj.attibutes[8] = true;
        }
    
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
  }
  
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
